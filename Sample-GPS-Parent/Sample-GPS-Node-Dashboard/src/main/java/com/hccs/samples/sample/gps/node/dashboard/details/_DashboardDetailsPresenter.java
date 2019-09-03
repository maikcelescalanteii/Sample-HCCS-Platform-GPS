package com.hccs.samples.sample.gps.node.dashboard.details;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;

import com.hccs.samples.sample.gps.core.annotations.PresentationModel;
import com.hccs.samples.sample.gps.models.beans.StudentBean;

@PresentationModel
public class _DashboardDetailsPresenter implements DashboardDetailsPresenter {

	@Autowired
	private DashboardDetailsGlass glass;

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
	public void setOnSelectItem(StudentBean studentBean) {
		// TODO Auto-generated method stub
		glass.setOnSelectItem(studentBean);
		
	}

	@Override
	public void setOnNew() {
		// TODO Auto-generated method stub
		glass.setOnNew();
	}

	@Override
	public void setOnEdit() {
		// TODO Auto-generated method stub
		glass.setOnEdit();
	}
	
	@Override
	public void setOnCancel() {
		// TODO Auto-generated method stub
		glass.setOnCancel();
	}
}
