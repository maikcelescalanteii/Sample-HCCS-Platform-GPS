package com.hccs.samples.sample.gps.node.employee.window;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;

import com.hccs.samples.sample.gps.core.annotations.SupervisingController;
import com.hccs.samples.sample.gps.models.StudentsModel;
import com.hccs.samples.sample.gps.models.beans.StudentBean;

@SupervisingController
public class _EmployeeWindowController implements EmployeeWindowController {

	Consumer<List<StudentBean>> studentConsumer;
	
	@Autowired
	private EmployeeWindowPresenter presenter;

	@Override
	public void init() {
		presenter.init();
	}

	@Override
	public void setupActions() {
		System.out.println("_WindowController, setupActions");
		presenter.addOnFetchAllAction(new Runnable() {
			@Override
			public void run() {
				studentConsumer.accept(StudentsModel.getStudents());
//			System.out.println("Hey");
			}
		});
	}

	@Override
	public void show() {
		presenter.show();
	}

	@Override
	public void addOnShowAction(Runnable runnable) {
		presenter.addOnShowAction(runnable);
	}

	@Override
	public void addOnSetAction(Consumer<List<StudentBean>> studentBean) {
		// TODO Auto-generated method stub
		System.out.println("_WindowController, addOnSetAction");
		studentConsumer = studentBean;
	}

	@Override
	public void addOnNewAction(Runnable runnable) {
		// TODO Auto-generated method stub
		presenter.addOnNewAction(runnable);
	}

	@Override
	public void addOnCancelAction(Runnable runnable) {
		// TODO Auto-generated method stub
		presenter.addOnCancelAction(runnable);
		
	}
}
