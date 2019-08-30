package com.hccs.samples.sample.gps.node.admin.settings.list;

import java.util.List;
import java.util.function.Consumer;

import com.hccs.samples.sample.gps.core.interfaces.SupervisingController;
import com.hccs.samples.sample.gps.models.beans.EmployeeBean;
import com.hccs.samples.sample.gps.models.beans.StudentBean;

public interface AdminSettingsListController extends SupervisingController {
	public void setData(List<EmployeeBean> data);
	
	public void setOnSelectItem(Consumer<Adapter> adapter);
	
	public void setOnInputMode();
}
