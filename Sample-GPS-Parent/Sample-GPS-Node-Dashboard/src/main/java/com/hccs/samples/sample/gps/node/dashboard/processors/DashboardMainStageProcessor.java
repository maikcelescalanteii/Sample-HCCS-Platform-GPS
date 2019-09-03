package com.hccs.samples.sample.gps.node.dashboard.processors;

import com.hccs.platform.HCCSPlatform;
import com.hccs.platform.enums.ProcessorState;
import com.hccs.platform.extendables.BasicProcessor;
import com.hccs.platform.utils.ResourceManager;

public class DashboardMainStageProcessor extends BasicProcessor {

	@Override
	public void run() {
		HCCSPlatform.getWindowService().setStageTitle("HCCS Sample Application");
		HCCSPlatform.getWindowService()
				.setStageIcon(ResourceManager.getImage("/com/hccs/sample/resources/_16x16/services.png"));
		setState(ProcessorState.SUCCEEDED);
	}

	@Override
	public int getPriority() {
		return 1;
	}
}
