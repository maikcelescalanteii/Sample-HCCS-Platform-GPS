package com.hccs.samples.sample.gps.actions.handlers;

import com.hccs.platform.annotations.Action;
import com.hccs.platform.annotations.ActionPath;
import com.hccs.platform.annotations.ActionPaths;
import com.hccs.platform.enums.ActionLocation;
import com.hccs.platform.extendables.ActionHandler;

@Action(name = "fetchall", menubarIcon = "/com/hccs/sample/resources/_16x16/fetchall.png", toolbarIcon = "/com/hccs/sample/resources/_16x16/fetchall.png", text = "Fetch All", contextAwareTo = "com.hccs.samples.sample.gps.actions.interfaces.FetchAll")
@ActionPaths({ @ActionPath(path = "File", position = 0, location = ActionLocation.MENUBAR),
		@ActionPath(path = "File", position = 0, location = ActionLocation.TOOLBAR) })
public class FetchAllActionHandler extends ActionHandler {

}
