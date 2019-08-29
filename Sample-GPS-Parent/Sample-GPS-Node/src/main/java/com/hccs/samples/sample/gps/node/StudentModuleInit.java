package com.hccs.samples.sample.gps.node;

import com.hccs.platform.HCCSPlatform;
import com.hccs.platform.interfaces.ModuleInit;
import com.hccs.samples.sample.gps.node.processors.LayoutProcessor;
import com.hccs.samples.sample.gps.node.processors.MainStageProcessor;
import com.hccs.samples.sample.gps.node.processors.StatusBarInitProcessor;

public class StudentModuleInit implements ModuleInit {

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
		HCCSPlatform.getModuleService().addPreProcessors(new MainStageProcessor());
		HCCSPlatform.getModuleService().addPreProcessors(new LayoutProcessor());
		HCCSPlatform.getModuleService().addPreProcessors(new StatusBarInitProcessor());

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
