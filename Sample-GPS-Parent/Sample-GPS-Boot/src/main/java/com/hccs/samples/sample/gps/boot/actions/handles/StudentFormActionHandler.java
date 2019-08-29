package com.hccs.samples.sample.gps.boot.actions.handles;

import com.hccs.platform.annotations.Action;
import com.hccs.platform.annotations.ActionPath;
import com.hccs.platform.annotations.ActionPaths;
import com.hccs.platform.enums.ActionLocation;
import com.hccs.platform.extendables.ActionHandler;
import com.hccs.samples.sample.gps.boot.Context;
import com.hccs.samples.sample.gps.node.StudentModuleConfig;
import com.hccs.samples.sample.gps.node.form.StudentForm;

import javafx.event.ActionEvent;
@Action(name = "studentreportcard", toolbarIcon = "/com/hccs/sample/resources/_16x16/studentreportcard.png", text = "Student Report Card")
@ActionPaths({ @ActionPath(path = "Scenes", position = 0, location = ActionLocation.TOOLBAR) })

public class StudentFormActionHandler extends ActionHandler {
	@Override
	public void handle(ActionEvent event) {
		System.out.println("Loading Students Report Card Window....");
		Context.initialize();
		Context.lookup("StudentModuleConfig", StudentModuleConfig.class);
		StudentForm form = Context.getBean(StudentForm.class);
		form.show();
	}
}
