package com.hccs.samples.sample.gps.node.admin.settings.window;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;

import com.hccs.samples.sample.gps.core.annotations.SupervisingController;
import com.hccs.samples.sample.gps.models.EmployeeModel;
import com.hccs.samples.sample.gps.models.StudentsModel;
import com.hccs.samples.sample.gps.models.beans.EmployeeBean;
import com.hccs.samples.sample.gps.models.beans.StudentBean;

@SupervisingController
public class _AdminSettingsWindowController implements AdminSettingsWindowController {

	Consumer<List<EmployeeBean>> studentConsumer;
	
	@Autowired
	private AdminSettingsWindowPresenter presenter;

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
				System.out.println("Hey employee");
				studentConsumer.accept(EmployeeModel.getEmployees());
			
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
	public void addOnSetAction(Consumer<List<EmployeeBean>> employeeBean) {
		// TODO Auto-generated method stub
		System.out.println("_WindowController, addOnSetAction");
		studentConsumer = employeeBean;
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

	@Override
	public void addOnEditAction(Runnable runnable) {
		// TODO Auto-generated method stub
		presenter.addOnEditAction(runnable);
		
	}

	@Override
	public void addOnSelectedItemAction() {
		// TODO Auto-generated method stub
		presenter.addOnSelectedItemAction();
	}
}
