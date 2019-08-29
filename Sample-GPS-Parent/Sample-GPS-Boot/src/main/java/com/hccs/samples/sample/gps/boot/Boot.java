package com.hccs.samples.sample.gps.boot;

import com.hccs.platform.interfaces.ModuleInit;

public class Boot implements ModuleInit {

	@Override
	public String actionScan() {
		// TODO Auto-generated method stub
		System.out.println("Boot class, actionScan method");
		return "com.hccs.samples.sample.gps.boot.actions.handles";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		System.out.println("Boot class, getName method");
		return "Sample-GPS-Boot";
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("Boot class, init method");
//		HCCSPlatform.getModuleService().addPreProcessors(new NodeFormProcessor());
//		HCCSPlatform.getModuleService().addPreProcessors(new PlatformMainProcessor());
	}

	@Override
	public String topComponentScan() {
		// TODO Auto-generated method stub
		System.out.println("Boot class, topComponentScan method");
		return null;
	}
}