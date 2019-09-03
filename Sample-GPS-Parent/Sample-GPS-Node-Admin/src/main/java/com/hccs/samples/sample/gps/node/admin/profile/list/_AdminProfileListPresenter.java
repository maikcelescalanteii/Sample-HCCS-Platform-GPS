package com.hccs.samples.sample.gps.node.admin.profile.list;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;

import com.hccs.samples.sample.gps.core.annotations.PresentationModel;
import com.hccs.samples.sample.gps.models.beans.StudentBean;

import javafx.application.Platform;

@PresentationModel
public class _AdminProfileListPresenter implements AdminProfileListPresenter {

	@Autowired
	private AdminProfileListGlass glass;

	@Override
	public void init() {
		glass.init();
	}

	@Override
	public void setData(List<Adapter> adapters) {
		System.out.println("_ListPresenter, setData method");
		Platform.runLater(() -> glass.setData(adapters));
	}

	@Override
	public void setOnSelectItem(Consumer<Adapter> adapter) {
		// TODO Auto-generated method stub
		glass.setOnSelectItem(adapter);
		
	}

	@Override
	public void setOnModifyList() {
		// TODO Auto-generated method stub
		glass.setOnModifyList();
		
	}
}
