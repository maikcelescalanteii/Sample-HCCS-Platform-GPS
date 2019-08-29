package com.hccs.samples.sample.gps.node.employee.details;

import java.util.List;
import java.util.function.Consumer;

import com.hccs.samples.sample.gps.core.interfaces.PresentationModel;
import com.hccs.samples.sample.gps.models.beans.EmployeeBean;
import com.hccs.samples.sample.gps.models.beans.StudentBean;

public interface EmployeeDetailsPresenter extends PresentationModel {

	public void setOnClearFilter(Runnable runnable);

	public void setOnApply(Consumer<List<String>> consumer);
	
	public void setOnSelectItem(EmployeeBean employeeBean);
	
	public void setOnModifyList (Runnable runnable);
	
	public void setOnNew ();
	
	public void setOnCancel ();
	

}
