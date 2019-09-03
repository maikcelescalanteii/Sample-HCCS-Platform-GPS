package com.hccs.samples.sample.gps.node.dashboard.list;

import java.util.List;
import java.util.function.Consumer;

import com.hccs.samples.sample.gps.core.interfaces.SupervisingController;
import com.hccs.samples.sample.gps.models.beans.StudentBean;

public interface DashboardListController extends SupervisingController {
	public void setData(List<StudentBean> data);
	
	public void setOnSelectItem(Consumer<DashboardAdapter> adapter);
	
	public void setOnInputMode();
	
	public void setOnCancelMode();
}
