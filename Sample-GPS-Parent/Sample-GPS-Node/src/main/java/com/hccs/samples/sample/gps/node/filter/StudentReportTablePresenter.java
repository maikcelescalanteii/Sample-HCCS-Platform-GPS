package com.hccs.samples.sample.gps.node.filter;

import java.util.List;
import java.util.function.Consumer;

import com.hccs.samples.sample.gps.core.interfaces.PresentationModel;
import com.hccs.samples.sample.gps.models.beans.StudentBean;
import com.hccs.samples.sample.gps.node.list.Adapter;

public interface StudentReportTablePresenter extends PresentationModel {

	public void setOnClearFilter(Runnable runnable);

	public void setOnApply(Consumer<List<String>> consumer);
	
	public void setOnSelectItem(StudentBean studentBean);
	
	public void setOnNew ();
	
	public void setOnEdit ();
	
	public void setOnCancel ();
	

}
