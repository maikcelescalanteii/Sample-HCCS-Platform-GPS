package com.hccs.samples.sample.gps.models;

import com.hccs.platform.interfaces.ModuleInit;

public class ModelsModuleInit implements ModuleInit {

	public String actionScan() {
		// TODO Auto-generated method stub
		System.out.println("ModelsModuleInit class, actionScan method");
		return null;
	}

	public String getName() {
		// TODO Auto-generated method stub
		System.out.println("ModelsModuleInit class, getName method");
		return "Sample-GPS-Models";
	}

	public void init() {
		// TODO Auto-generated method stub
		System.out.println("ModelsModuleInit class, init method");
		StudentsModel.initialize();
		EmployeeModel.initialize();

	}

	public String topComponentScan() {
		// TODO Auto-generated method stub
		System.out.println("ModelsModuleInit class, topComponentScan method");
		return null;
	}

}
