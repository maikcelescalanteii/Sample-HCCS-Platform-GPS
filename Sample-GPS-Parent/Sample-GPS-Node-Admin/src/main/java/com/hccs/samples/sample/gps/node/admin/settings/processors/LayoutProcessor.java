package com.hccs.samples.sample.gps.node.admin.settings.processors;

import com.hccs.platform.HCCSPlatform;
import com.hccs.platform.components.tags.LayoutContainer;
import com.hccs.platform.components.tags.LayoutGroup;
import com.hccs.platform.components.tags.LayoutGroup.SplitType;
import com.hccs.platform.enums.ProcessorState;
import com.hccs.platform.extendables.BasicProcessor;

public class LayoutProcessor extends BasicProcessor {
	@Override
	public void run() {
		try {

			// LayoutContainer left = new LayoutContainer("left", "20", 0, false);
			// LayoutContainer center = new LayoutContainer("center", "70", 1);
			// LayoutContainer right = new LayoutContainer("right", "10", 2);
			// LayoutContainer top = new LayoutContainer("top", "80", 0);
			// LayoutContainer bottom = new LayoutContainer("bottom", "10", 2);
			//
			// LayoutGroup vertical = new LayoutGroup(SplitType.VERTICAL, "80", 1);
			// vertical.setLayoutContainers(left, center, right);
			//
			// LayoutGroup horizontal = new LayoutGroup(SplitType.HORIZONTAL);
			// horizontal.setLayoutContainers(top, bottom);
			// horizontal.setLayoutGroups(vertical);
			//
			// HCCSPlatform.getWindowService().setLayout(horizontal);

			LayoutGroup body = new LayoutGroup(SplitType.VERTICAL, "100", 0);
			LayoutContainer container = new LayoutContainer("container", "100", 0);
			body.setLayoutContainers(container);

			HCCSPlatform.getWindowService().setLayout(body);

			// InputStream is =
			// getClass().getResourceAsStream("/com/sample/resources/layout/Layout.java");
			// is.close();
			setState(ProcessorState.SUCCEEDED);
		} catch (Exception e) {
			e.printStackTrace();
			setState(ProcessorState.ERROR);
		}
	}

	@Override
	public int getPriority() {
		return 0;
	}
}
