package com.hccs.samples.sample.gps.node.admin.settings.details;

import java.util.List;
import java.util.function.Consumer;

import com.hccs.samples.sample.gps.core.interfaces.SupervisingController;
import com.hccs.samples.sample.gps.node.admin.settings.list.Adapter;

public interface AdminSettingsDetailsController extends SupervisingController {

	public void setOnApply(Consumer<List<String>> consumer);
	
	public void setOnSelectItem(Adapter adapter);
	
	public void setOnNew ();
	
	public void setOnEdit ();
	
	public void setOnCancel ();
}
