package com.hccs.samples.sample.gps.boot.processors;

import com.hccs.platform.HCCSPlatform;
import com.hccs.platform.components.status.DateElement;
import com.hccs.platform.components.status.MemoryElement;
import com.hccs.platform.components.status.ProgressElement;
import com.hccs.platform.components.status.TextInfoElement;
import com.hccs.platform.enums.ProcessorState;
import com.hccs.platform.extendables.BasicProcessor;
import com.hccs.samples.sample.gps.boot.Context;
import com.hccs.samples.sample.gps.node.admin.profile.AdminProfileModuleConfig;
import com.hccs.samples.sample.gps.node.admin.profile.form.AdminProfileForm;
import com.hccs.samples.sample.gps.node.dashboard.DashboardModuleConfig;
import com.hccs.samples.sample.gps.node.dashboard.form.DashboardForm;

public class ContextInitProcessor extends BasicProcessor {
	@Override
	public void run() {
		Context.initialize();
		setState(ProcessorState.SUCCEEDED);
	}

	@Override
	public int getPriority() {
		return 0;
	}
}
