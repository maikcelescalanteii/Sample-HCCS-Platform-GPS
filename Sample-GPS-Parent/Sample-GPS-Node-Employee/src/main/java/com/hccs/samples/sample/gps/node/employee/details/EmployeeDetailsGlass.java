package com.hccs.samples.sample.gps.node.employee.details;

import java.util.List;
import java.util.function.Consumer;

import com.hccs.samples.sample.gps.core.interfaces.Glass;
import com.hccs.samples.sample.gps.models.beans.EmployeeBean;
import com.hccs.samples.sample.gps.models.beans.StudentBean;
import com.hccs.samples.sample.gps.node.employee.proxies.PartialGlass;

public interface EmployeeDetailsGlass extends Glass, PartialGlass {

	public void setOnClearFilter(Runnable runnable);

	public void setOnApply(Consumer<List<String>> consumer);
	
	public void setOnSelectItem(EmployeeBean employeeBean);
	
	public void setOnNew ();
	
	public void setOnEdit ();
	
	public void setOnCancel ();

}
