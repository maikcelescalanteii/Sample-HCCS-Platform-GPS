package com.hccs.samples.sample.gps.node.dashboard;

import com.hccs.platform.HCCSPlatform;
import com.hccs.platform.interfaces.ModuleInit;
import com.hccs.samples.sample.gps.node.dashboard.processors.DashboardLayoutProcessor;
import com.hccs.samples.sample.gps.node.dashboard.processors.DashboardMainStageProcessor;
import com.hccs.samples.sample.gps.node.dashboard.processors.DashboardStatusBarInitProcessor;

public class DashboardModuleInit implements ModuleInit {

	@Override
	public String actionScan() {
		// TODO Auto-generated method stub
		System.out.println("StudentModuleInit class, actionScan method");
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		System.out.println("StudentModuleInit class, getName method");
		return "Sample-GPS-Node";
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("StudentModuleInit class, init method");
		HCCSPlatform.getModuleService().addPreProcessors(new DashboardMainStageProcessor());
		HCCSPlatform.getModuleService().addPreProcessors(new DashboardLayoutProcessor());
		HCCSPlatform.getModuleService().addPreProcessors(new DashboardStatusBarInitProcessor());

	}

	@Override
	public String topComponentScan() {
		// TODO Auto-generated method stub
		System.out.println("StudentModuleInit class, topComponentScan method");
//		return "com.hccs.samples.sample.gps.app.topwindows";
//		return "com.hccs.samples.sample.gps.node.window";
		return "com.hccs.samples.sample.gps.node.window";
//		return "com.hccs.samples.sample.gps.boot.actions.handles";
	}

}
