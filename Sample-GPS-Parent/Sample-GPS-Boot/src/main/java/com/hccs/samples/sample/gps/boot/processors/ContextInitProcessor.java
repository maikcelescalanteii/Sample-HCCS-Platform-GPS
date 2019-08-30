package com.hccs.samples.sample.gps.boot.processors;

import com.hccs.platform.HCCSPlatform;
import com.hccs.platform.components.status.DateElement;
import com.hccs.platform.components.status.MemoryElement;
import com.hccs.platform.components.status.ProgressElement;
import com.hccs.platform.components.status.TextInfoElement;
import com.hccs.platform.enums.ProcessorState;
import com.hccs.platform.extendables.BasicProcessor;
import com.hccs.samples.sample.gps.boot.Context;

public class ContextInitProcessor extends BasicProcessor {
	@Override
	public void run() {
		Context.initialize();
		setState(ProcessorState.SUCCEEDED);
	}

	@Override
	public int getPriority() {
		return 2;
	}
}
