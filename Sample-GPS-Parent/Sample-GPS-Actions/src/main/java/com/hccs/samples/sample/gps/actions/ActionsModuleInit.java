package com.hccs.samples.sample.gps.actions;
import com.hccs.platform.HCCSPlatform;
import com.hccs.platform.interfaces.ModuleInit;
import com.hccs.samples.sample.gps.actions.processors.ActionLayoutProcessor;

public class ActionsModuleInit implements ModuleInit {

	@Override
	public String actionScan() {
		// TODO Auto-generated method stub
		System.out.println("ActionsModuleInit class, actionScan method");
		return "com.hccs.samples.sample.gps.actions.handlers";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		System.out.println("ActionsModuleInit class, getName method");
		return "Sample-GPS-Actions";
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("ActionsModuleInit class, init method");
		HCCSPlatform.getModuleService().addPreProcessors(new ActionLayoutProcessor());
	}

	@Override
	public String topComponentScan() {
		// TODO Auto-generated method stub
		System.out.println("ActionsModuleInit class, topComponentScan method");
		return null;
	}

}
