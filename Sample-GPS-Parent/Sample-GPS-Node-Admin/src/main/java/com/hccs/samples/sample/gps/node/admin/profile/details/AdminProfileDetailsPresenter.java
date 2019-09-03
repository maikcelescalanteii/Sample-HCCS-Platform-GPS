package com.hccs.samples.sample.gps.node.admin.profile.details;

import java.util.List;
import java.util.function.Consumer;

import com.hccs.samples.sample.gps.core.interfaces.PresentationModel;
import com.hccs.samples.sample.gps.models.beans.EmployeeBean;
import com.hccs.samples.sample.gps.models.beans.StudentBean;

public interface AdminProfileDetailsPresenter extends PresentationModel {

	public void setOnClearFilter(Runnable runnable);

	public void setOnApply(Consumer<List<String>> consumer);
	
	public void setOnSelectItem(EmployeeBean employeeBean);
	
	public void setOnNew ();
	
	public void setOnEdit ();
	
	public void setOnCancel ();
	

}
