package com.hccs.samples.sample.gps.node.employee.window;

import com.hccs.samples.sample.gps.core.interfaces.Glass;
import com.hccs.samples.sample.gps.core.interfaces.GlassAttacher;
import com.hccs.samples.sample.gps.core.interfaces.Showable;

import javafx.scene.Node;

public interface EmployeeWindowGlass extends Glass, Showable {
	public GlassAttacher<Node> getFilterAttacher();

	public GlassAttacher<Node> getListAttacher();

	public void addOnShowAction(Runnable runnable);
	
	public void addOnFetchAllAction(Runnable runnable);
	
	public void addOnCancelAction(Runnable runnable);
	
	public void addOnNewAction(Runnable runnable);
	
	public void addOnEditAction(Runnable runnable);
	
	public void addOnSelectedItemAction();
}
