package com.hccs.samples.sample.gps.node.admin.settings;

import com.hccs.platform.HCCSPlatform;
import com.hccs.platform.interfaces.ModuleInit;
import com.hccs.samples.sample.gps.node.admin.settings.processors.LayoutProcessor;
import com.hccs.samples.sample.gps.node.admin.settings.processors.MainStageProcessor;
import com.hccs.samples.sample.gps.node.admin.settings.processors.StatusBarInitProcessor;

public class AdminSettingsModuleInit implements ModuleInit {

	@Override
	public String actionScan() {
		// TODO Auto-generated method stub
		System.out.println("AdminSettingsModuleInit class, actionScan method");
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		System.out.println("AdminSettingsModuleInit class, getName method");
		return "Sample-GPS-Node-Admin";
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("AdminSettingsModuleInit class, init method");
		HCCSPlatform.getModuleService().addPreProcessors(new MainStageProcessor());
		HCCSPlatform.getModuleService().addPreProcessors(new LayoutProcessor());
		HCCSPlatform.getModuleService().addPreProcessors(new StatusBarInitProcessor());

	}

	@Override
	public String topComponentScan() {
		// TODO Auto-generated method stub
		System.out.println("AdminSettingsModuleInit class, topComponentScan method");
		return "com.hccs.samples.sample.gps.node.admin.settings.window";
//		return "com.hccs.samples.sample.gps.boot.actions.handles";
	}

}
