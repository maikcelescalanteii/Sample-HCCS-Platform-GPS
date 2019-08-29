package com.hccs.samples.sample.gps.node.list;

import java.util.List;
import java.util.function.Consumer;

import com.hccs.samples.sample.gps.core.interfaces.PresentationModel;

public interface StudentListPresenter extends PresentationModel {
	public void setData(List<Adapter> adapters);
	
	public void setOnSelectItem(Consumer<Adapter> adapter);
	
	public void setOnInputMode();
	
	public void setOnCancelMode();
}
