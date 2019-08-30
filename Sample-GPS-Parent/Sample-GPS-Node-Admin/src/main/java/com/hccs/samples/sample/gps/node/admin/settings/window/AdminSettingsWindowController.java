package com.hccs.samples.sample.gps.node.admin.settings.window;

import java.util.List;
import java.util.function.Consumer;

import com.hccs.samples.sample.gps.core.interfaces.Showable;
import com.hccs.samples.sample.gps.core.interfaces.SupervisingController;
import com.hccs.samples.sample.gps.models.beans.EmployeeBean;
import com.hccs.samples.sample.gps.models.beans.StudentBean;

public interface AdminSettingsWindowController extends SupervisingController, Showable {
	public void addOnShowAction(Runnable runnable);
	
	public void addOnSetAction(Consumer<List<EmployeeBean>> employeeBean);
	
	public void addOnCancelAction(Runnable runnable);
	
	public void addOnNewAction(Runnable runnable);
	
	public void addOnEditAction(Runnable runnable);
	
	public void addOnSelectedItemAction();
	
}
