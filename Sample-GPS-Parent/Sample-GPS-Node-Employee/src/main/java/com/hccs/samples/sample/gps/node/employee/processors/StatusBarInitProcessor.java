package com.hccs.samples.sample.gps.node.employee.processors;

import com.hccs.platform.HCCSPlatform;
import com.hccs.platform.components.status.DateElement;
import com.hccs.platform.components.status.MemoryElement;
import com.hccs.platform.components.status.ProgressElement;
import com.hccs.platform.components.status.TextInfoElement;
import com.hccs.platform.enums.ProcessorState;
import com.hccs.platform.extendables.BasicProcessor;

public class StatusBarInitProcessor extends BasicProcessor {
	@Override
	public void run() {
//		HCCSPlatform.getStatusService().addLeftElements(new TextInfoElement());
//		HCCSPlatform.getStatusService().addRightElements(new DateElement(), new MemoryElement(), new ProgressElement());
		setState(ProcessorState.SUCCEEDED);
	}

	@Override
	public int getPriority() {
		return 2;
	}
}
