package com.hccs.samples.sample.gps.actions.handlers;

import com.hccs.platform.annotations.Action;
import com.hccs.platform.annotations.ActionPath;
import com.hccs.platform.annotations.ActionPaths;
import com.hccs.platform.enums.ActionLocation;
import com.hccs.platform.extendables.ActionHandler;

@Action(name = "save", menubarIcon = "/com/hccs/sample/resources/_16x16/save.png", toolbarIcon = "/com/hccs/sample/resources/_16x16/save.png", text = "Save", contextAwareTo = "com.hccs.samples.sample.gps.actions.interfaces.Save")
@ActionPaths({ @ActionPath(path = "Edit", position = 2, location = ActionLocation.MENUBAR),
		@ActionPath(path = "Edit", position = 2, location = ActionLocation.TOOLBAR) })
public class SaveActionHandler extends ActionHandler {

}
