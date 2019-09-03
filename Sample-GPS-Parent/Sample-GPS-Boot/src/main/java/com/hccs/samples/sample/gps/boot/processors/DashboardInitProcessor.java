package com.hccs.samples.sample.gps.boot.processors;

import com.hccs.platform.enums.ProcessorState;
import com.hccs.platform.extendables.BasicProcessor;
import com.hccs.samples.sample.gps.boot.Context;
import com.hccs.samples.sample.gps.node.dashboard.DashboardModuleConfig;
import com.hccs.samples.sample.gps.node.dashboard.form.DashboardForm;

public class DashboardInitProcessor extends BasicProcessor {
	@Override
	public void run() {
		System.out.println("Loading Dashboard Window....");
		Context.lookup("DashboardModuleConfig", DashboardModuleConfig.class);
		DashboardForm dashboard = Context.getBean(DashboardForm.class);
		dashboard.show();
		
		setState(ProcessorState.SUCCEEDED);
		
//		HCCSPlatform.getWindowService().loadTopWindow(_DashboardWindowGlass.class);
		
	}

	@Override
	public int getPriority() {
		return 1;
	}
}
