package com.hccs.samples.sample.gps.boot.actions.handles;

import com.hccs.platform.annotations.Action;
import com.hccs.platform.annotations.ActionPath;
import com.hccs.platform.annotations.ActionPaths;
import com.hccs.platform.enums.ActionLocation;
import com.hccs.platform.extendables.ActionHandler;
import com.hccs.samples.sample.gps.boot.Context;
import com.hccs.samples.sample.gps.node.admin.profile.AdminProfileModuleConfig;
import com.hccs.samples.sample.gps.node.admin.profile.form.AdminProfileForm;
import com.hccs.samples.sample.gps.node.admin.settings.AdminSettingsModuleConfig;
import com.hccs.samples.sample.gps.node.admin.settings.form.AdminSettingsForm;

import javafx.event.ActionEvent;
@Action(name = "admin", toolbarIcon = "/com/hccs/sample/resources/_16x16/studentreportcard.png", text = "Admin")
@ActionPaths({ @ActionPath(path = "Scenes", position = 2, location = ActionLocation.TOOLBAR) })

public class AdminFormActionHandler extends ActionHandler {
	@Override
	public void handle(ActionEvent event) {
		System.out.println("Loading Admin Settings Window....");
//		Context.initialize();
		Context.lookup("AdminSettingsModuleConfig", AdminSettingsModuleConfig.class);
		AdminSettingsForm adminSettings = Context.getBean(AdminSettingsForm.class);
		adminSettings.show();
		
		Context.lookup("AdminProfileModuleConfig", AdminProfileModuleConfig.class);
		AdminProfileForm adminProfile = Context.getBean(AdminProfileForm.class);
		adminProfile.show();
	}
}
