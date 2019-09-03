package com.hccs.samples.sample.gps.node.dashboard.list;

import java.util.List;
import java.util.function.Consumer;

import com.hccs.samples.sample.gps.core.interfaces.Glass;
import com.hccs.samples.sample.gps.node.dashboard.proxies.PartialGlass;

public interface DashboardListGlass extends Glass, PartialGlass {

	public void setData(List<DashboardAdapter> adapters);
	
	public void setOnSelectItem(Consumer<DashboardAdapter> adapter);

	public void setOnInputMode();
	
	public void setOnCancelMode();
}
