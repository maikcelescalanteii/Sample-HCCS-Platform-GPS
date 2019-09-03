package com.hccs.samples.sample.gps.node.admin.profile.window;

import com.hccs.samples.sample.gps.core.interfaces.PresentationModel;
import com.hccs.samples.sample.gps.core.interfaces.Showable;

public interface AdminProfileWindowPresenter extends PresentationModel, Showable {

	public void addOnShowAction(Runnable runnable);
	
	public void addOnFetchAllAction(Runnable runnable);
	
	public void addOnCancelAction(Runnable runnable);
	
	public void addOnNewAction(Runnable runnable);
	
	public void addOnEditAction(Runnable runnable);
	
	public void addOnSelectedItemAction();
}
