package com.hccs.samples.sample.gps.node.admin.profile.details;

import java.util.List;
import java.util.function.Consumer;

import com.hccs.samples.sample.gps.core.interfaces.SupervisingController;
import com.hccs.samples.sample.gps.node.admin.profile.list.Adapter;

public interface AdminProfileDetailsController extends SupervisingController {

	public void setOnApply(Consumer<List<String>> consumer);
	
	public void setOnSelectItem(Adapter adapter);
	
	public void setOnNew ();
	
	public void setOnEdit ();
	
	public void setOnCancel ();
}
