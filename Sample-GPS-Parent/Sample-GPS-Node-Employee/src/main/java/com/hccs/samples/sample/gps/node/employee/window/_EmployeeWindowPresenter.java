package com.hccs.samples.sample.gps.node.employee.window;

import org.springframework.beans.factory.annotation.Autowired;

import com.hccs.samples.sample.gps.core.annotations.PresentationModel;

@PresentationModel
public class _EmployeeWindowPresenter implements EmployeeWindowPresenter {

	@Autowired
	private EmployeeWindowGlass glass;

	@Override
	public void init() {
		glass.init();
	}

	@Override
	public void show() {
		glass.show();
	}

	@Override
	public void addOnShowAction(Runnable runnable) {
		glass.addOnShowAction(runnable);
	}

	@Override
	public void addOnFetchAllAction(Runnable runnable) {
		System.out.println("_WindowPresenter, addOnFetchAllAction");
		glass.addOnFetchAllAction(runnable);
		
	}

	@Override
	public void addOnCancelAction(Runnable runnable) {
		// TODO Auto-generated method stub
		glass.addOnCancelAction(runnable);
	}

	@Override
	public void addOnNewAction(Runnable runnable) {
		// TODO Auto-generated method stub
		glass.addOnNewAction(runnable);
		
	}

	@Override
	public void addOnEditAction(Runnable runnable) {
		// TODO Auto-generated method stub
		glass.addOnEditAction(runnable);
	}

	@Override
	public void addOnSelectedItemAction() {
		// TODO Auto-generated method stub
		glass.addOnSelectedItemAction();
	}

}
