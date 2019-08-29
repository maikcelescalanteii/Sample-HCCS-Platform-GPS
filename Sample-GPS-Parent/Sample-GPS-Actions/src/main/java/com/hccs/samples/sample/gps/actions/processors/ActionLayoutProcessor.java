package com.hccs.samples.sample.gps.actions.processors;

import com.hccs.platform.HCCSPlatform;
import com.hccs.platform.components.tags.ActionLayout;
import com.hccs.platform.components.tags.Actions;
import com.hccs.platform.components.tags.Menu;
import com.hccs.platform.components.tags.MenuBarLayout;
import com.hccs.platform.components.tags.ToolBarLayout;
import com.hccs.platform.enums.ProcessorState;
import com.hccs.platform.extendables.BasicProcessor;

public class ActionLayoutProcessor extends BasicProcessor {

	@Override
	public void run() {
		try {
			System.out.println("ActionLayoutProcessor was called.");

			MenuBarLayout menuLayout = new MenuBarLayout();
			menuLayout.setMenus(new Menu("File"), new Menu("Edit"), new Menu("Help"));
			ToolBarLayout toolbarLayout = new ToolBarLayout();
			toolbarLayout.setActions(new Actions("Scenes"), new Actions("File"), new Actions("Edit"));
			ActionLayout actionLayout = new ActionLayout(menuLayout, toolbarLayout);

			HCCSPlatform.getWindowService().setActionLayout(actionLayout);
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
