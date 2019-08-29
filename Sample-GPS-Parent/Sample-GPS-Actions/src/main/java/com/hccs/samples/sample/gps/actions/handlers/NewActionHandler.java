package com.hccs.samples.sample.gps.actions.handlers;

import com.hccs.platform.annotations.Action;
import com.hccs.platform.annotations.ActionPath;
import com.hccs.platform.annotations.ActionPaths;
import com.hccs.platform.enums.ActionLocation;
import com.hccs.platform.extendables.ActionHandler;

@Action(name = "new", menubarIcon = "/com/hccs/sample/resources/_16x16/new.png", toolbarIcon = "/com/hccs/sample/resources/_16x16/new.png", text = "New", contextAwareTo = "com.hccs.samples.sample.gps.actions.interfaces.New")
@ActionPaths({ @ActionPath(path = "File", position = 1, location = ActionLocation.MENUBAR),
		@ActionPath(path = "File", position = 1, location = ActionLocation.TOOLBAR) })
public class NewActionHandler extends ActionHandler {

}
