package com.hccs.samples.sample.gps.node.employee.details;

import java.util.List;
import java.util.function.Consumer;

import com.hccs.samples.sample.gps.core.interfaces.SupervisingController;
import com.hccs.samples.sample.gps.node.employee.list.Adapter;

public interface EmployeeDetailsController extends SupervisingController {

	public void setOnApply(Consumer<List<String>> consumer);
	
	public void setOnSelectItem(Adapter adapter);
	
	public void setOnModifyList (Runnable runnable);
	
	public void setOnNew ();
	
	public void setOnCancel ();
}
