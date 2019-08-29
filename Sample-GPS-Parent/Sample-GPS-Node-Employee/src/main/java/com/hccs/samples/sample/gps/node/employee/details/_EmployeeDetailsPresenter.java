package com.hccs.samples.sample.gps.node.employee.details;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;

import com.hccs.samples.sample.gps.core.annotations.PresentationModel;
import com.hccs.samples.sample.gps.models.beans.EmployeeBean;
import com.hccs.samples.sample.gps.models.beans.StudentBean;

@PresentationModel
public class _EmployeeDetailsPresenter implements EmployeeDetailsPresenter {

	@Autowired
	private EmployeeDetailsGlass glass;

	@Override
	public void init() {
		glass.init();
	}

	@Override
	public void setOnClearFilter(Runnable runnable) {
		glass.setOnClearFilter(runnable);
	}

	@Override
	public void setOnApply(Consumer<List<String>> consumer) {
		glass.setOnApply(consumer);
	}

	@Override
	public void setOnSelectItem(EmployeeBean employeeBean) {
		// TODO Auto-generated method stub
		glass.setOnSelectItem(employeeBean);
		
	}
	
	@Override
	public void setOnModifyList(Runnable runnable) {
		// TODO Auto-generated method stub
		glass.setOnModifyList(runnable);
	}

	@Override
	public void setOnNew() {
		// TODO Auto-generated method stub
		glass.setOnNew();
	}

	@Override
	public void setOnCancel() {
		// TODO Auto-generated method stub
		glass.setOnCancel();
	}
}
