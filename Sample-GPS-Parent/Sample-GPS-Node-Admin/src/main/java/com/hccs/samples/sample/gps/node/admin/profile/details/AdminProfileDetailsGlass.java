package com.hccs.samples.sample.gps.node.admin.profile.details;

import java.util.List;
import java.util.function.Consumer;

import com.hccs.samples.sample.gps.core.interfaces.Glass;
import com.hccs.samples.sample.gps.models.beans.EmployeeBean;
import com.hccs.samples.sample.gps.models.beans.StudentBean;
import com.hccs.samples.sample.gps.node.admin.settings.proxies.PartialGlass;

public interface AdminProfileDetailsGlass extends Glass, PartialGlass {

	public void setOnClearFilter(Runnable runnable);

	public void setOnApply(Consumer<List<String>> consumer);
	
	public void setOnSelectItem(EmployeeBean employeeBean);
	
	public void setOnNew ();
	
	public void setOnEdit ();
	
	public void setOnCancel ();

}
