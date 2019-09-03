package com.hccs.samples.sample.gps.node.dashboard.list;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;

import com.hccs.samples.sample.gps.core.annotations.PresentationModel;
import com.hccs.samples.sample.gps.models.beans.StudentBean;

import javafx.application.Platform;

@PresentationModel
public class _DashboardListPresenter implements DashboardListPresenter {

	@Autowired
	private DashboardListGlass glass;

	@Override
	public void init() {
		glass.init();
	}

	@Override
	public void setData(List<DashboardAdapter> adapters) {
		System.out.println("_ListPresenter, setData method");
		Platform.runLater(() -> glass.setData(adapters));
	}

	@Override
	public void setOnSelectItem(Consumer<DashboardAdapter> adapter) {
		// TODO Auto-generated method stub
		glass.setOnSelectItem(adapter);
		
	}

	@Override
	public void setOnInputMode() {
		// TODO Auto-generated method stub
		glass.setOnInputMode();
		
	}

	@Override
	public void setOnCancelMode() {
		// TODO Auto-generated method stub
		glass.setOnCancelMode();
	}
}
