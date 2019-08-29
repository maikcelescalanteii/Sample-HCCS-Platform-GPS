package com.hccs.samples.sample.gps.actions.handlers;

import com.hccs.platform.annotations.Action;
import com.hccs.platform.annotations.ActionPath;
import com.hccs.platform.annotations.ActionPaths;
import com.hccs.platform.enums.ActionLocation;
import com.hccs.platform.extendables.ActionHandler;

@Action(name = "edit", menubarIcon = "/com/hccs/sample/resources/_16x16/edit.png", toolbarIcon = "/com/hccs/sample/resources/_16x16/edit.png", text = "Edit", contextAwareTo = "com.hccs.samples.sample.gps.actions.interfaces.Edit")
@ActionPaths({ @ActionPath(path = "Edit", position = 0, location = ActionLocation.MENUBAR),
		@ActionPath(path = "Edit", position = 0, location = ActionLocation.TOOLBAR) })
public class EditActionHandler extends ActionHandler {

}
