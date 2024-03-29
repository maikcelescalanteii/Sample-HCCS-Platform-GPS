package com.hccs.samples.sample.gps.node.admin.profile.list;

import java.util.List;
import java.util.function.Consumer;

import com.hccs.samples.sample.gps.core.interfaces.PresentationModel;

public interface AdminProfileListPresenter extends PresentationModel {
	public void setData(List<Adapter> adapters);
	
	public void setOnSelectItem(Consumer<Adapter> adapter);
	
	public void setOnModifyList();
}
