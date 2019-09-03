package com.hccs.samples.sample.gps.node.admin.profile;

import com.hccs.platform.HCCSPlatform;
import com.hccs.platform.interfaces.ModuleInit;
import com.hccs.samples.sample.gps.node.admin.profile.processors.LayoutProcessor;
import com.hccs.samples.sample.gps.node.admin.profile.processors.MainStageProcessor;
import com.hccs.samples.sample.gps.node.admin.profile.processors.StatusBarInitProcessor;

public class AdminProfileModuleInit implements ModuleInit {

	@Override
	public String actionScan() {
		// TODO Auto-generated method stub
		System.out.println("AdminProfileModuleInit class, actionScan method");
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		System.out.println("AdminProfileModuleInit class, getName method");
		return "Sample-GPS-Node-Admin";
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("AdminProfileModuleInit class, init method");
		HCCSPlatform.getModuleService().addPreProcessors(new MainStageProcessor());
		HCCSPlatform.getModuleService().addPreProcessors(new LayoutProcessor());
		HCCSPlatform.getModuleService().addPreProcessors(new StatusBarInitProcessor());

	}

	@Override
	public String topComponentScan() {
		// TODO Auto-generated method stub
		System.out.println("AdminProfileModuleInit class, topComponentScan method");
		return "com.hccs.samples.sample.gps.node.admin.profile.window";
//		return "com.hccs.samples.sample.gps.boot.actions.handles";
	}

}
