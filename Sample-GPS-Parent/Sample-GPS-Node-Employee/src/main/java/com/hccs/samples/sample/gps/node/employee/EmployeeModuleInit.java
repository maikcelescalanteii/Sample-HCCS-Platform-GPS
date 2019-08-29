package com.hccs.samples.sample.gps.node.employee;

import com.hccs.platform.HCCSPlatform;
import com.hccs.platform.interfaces.ModuleInit;
import com.hccs.samples.sample.gps.node.employee.processors.LayoutProcessor;
import com.hccs.samples.sample.gps.node.employee.processors.MainStageProcessor;
import com.hccs.samples.sample.gps.node.employee.processors.StatusBarInitProcessor;

public class EmployeeModuleInit implements ModuleInit {

	@Override
	public String actionScan() {
		// TODO Auto-generated method stub
		System.out.println("EmployeeModuleInit class, actionScan method");
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		System.out.println("EmployeeModuleInit class, getName method");
		return "Sample-GPS-Node-Employee";
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("EmployeeModuleInit class, init method");
		HCCSPlatform.getModuleService().addPreProcessors(new MainStageProcessor());
		HCCSPlatform.getModuleService().addPreProcessors(new LayoutProcessor());
		HCCSPlatform.getModuleService().addPreProcessors(new StatusBarInitProcessor());

	}

	@Override
	public String topComponentScan() {
		// TODO Auto-generated method stub
		System.out.println("EmployeeModuleInit class, topComponentScan method");
		return "com.hccs.samples.sample.gps.node.employee.window";
//		return "com.hccs.samples.sample.gps.boot.actions.handles";
	}

}
