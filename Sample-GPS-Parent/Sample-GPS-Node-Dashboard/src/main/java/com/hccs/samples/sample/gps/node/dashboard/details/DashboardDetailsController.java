package com.hccs.samples.sample.gps.node.dashboard.details;

import java.util.List;
import java.util.function.Consumer;

import com.hccs.samples.sample.gps.core.interfaces.SupervisingController;
import com.hccs.samples.sample.gps.node.dashboard.list.DashboardAdapter;

public interface DashboardDetailsController extends SupervisingController {

	public void setOnApply(Consumer<List<String>> consumer);
	
	public void setOnSelectItem(DashboardAdapter adapter);
	
	public void setOnNew ();
	
	public void setOnEdit ();
	
	public void setOnCancel ();
}
