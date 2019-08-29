package com.hccs.samples.sample.gps.actions.handlers;

import com.hccs.platform.annotations.Action;
import com.hccs.platform.annotations.ActionPath;
import com.hccs.platform.annotations.ActionPaths;
import com.hccs.platform.enums.ActionLocation;
import com.hccs.platform.extendables.ActionHandler;

@Action(name = "cancel", menubarIcon = "/com/hccs/sample/resources/_16x16/cancel.png", toolbarIcon = "/com/hccs/sample/resources/_16x16/cancel.png", text = "Cancel", contextAwareTo = "com.hccs.samples.sample.gps.actions.interfaces.Cancel")
@ActionPaths({ @ActionPath(path = "Edit", position = 1, location = ActionLocation.MENUBAR),
		@ActionPath(path = "Edit", position = 1, location = ActionLocation.TOOLBAR) })
public class CancelActionHandler extends ActionHandler {

}
