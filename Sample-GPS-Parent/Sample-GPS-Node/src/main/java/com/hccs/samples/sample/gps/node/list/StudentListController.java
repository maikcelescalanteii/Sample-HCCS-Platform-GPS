package com.hccs.samples.sample.gps.node.list;

import java.util.List;
import java.util.function.Consumer;

import com.hccs.samples.sample.gps.core.interfaces.SupervisingController;
import com.hccs.samples.sample.gps.models.beans.StudentBean;

public interface StudentListController extends SupervisingController {
	public void setData(List<StudentBean> data);
	
	public void setOnSelectItem(Consumer<Adapter> adapter);
	
	public void setOnInputMode();
	
	public void setOnCancelMode();
}
