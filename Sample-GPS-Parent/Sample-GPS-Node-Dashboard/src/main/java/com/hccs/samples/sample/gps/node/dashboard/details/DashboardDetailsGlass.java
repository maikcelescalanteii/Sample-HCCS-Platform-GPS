package com.hccs.samples.sample.gps.node.dashboard.details;

import java.util.List;
import java.util.function.Consumer;

import com.hccs.samples.sample.gps.core.interfaces.Glass;
import com.hccs.samples.sample.gps.models.beans.StudentBean;
import com.hccs.samples.sample.gps.node.dashboard.list.Adapter;
import com.hccs.samples.sample.gps.node.dashboard.proxies.PartialGlass;

public interface DashboardDetailsGlass extends Glass, PartialGlass {

	public void setOnClearFilter(Runnable runnable);

	public void setOnApply(Consumer<List<String>> consumer);
	
	public void setOnSelectItem(StudentBean studentBean);
	
	public void setOnNew ();
	
	public void setOnEdit ();
	
	public void setOnCancel ();

}
