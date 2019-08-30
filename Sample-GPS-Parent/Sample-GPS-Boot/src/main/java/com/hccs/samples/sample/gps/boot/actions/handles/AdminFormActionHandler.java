package com.hccs.samples.sample.gps.boot.actions.handles;

import com.hccs.platform.annotations.Action;
import com.hccs.platform.annotations.ActionPath;
import com.hccs.platform.annotations.ActionPaths;
import com.hccs.platform.enums.ActionLocation;
import com.hccs.platform.extendables.ActionHandler;
import com.hccs.samples.sample.gps.boot.Context;
import com.hccs.samples.sample.gps.node.StudentModuleConfig;
import com.hccs.samples.sample.gps.node.employee.EmployeeModuleConfig;
import com.hccs.samples.sample.gps.node.employee.form.EmployeeForm;
import com.hccs.samples.sample.gps.node.form.StudentForm;

import javafx.event.ActionEvent;
@Action(name = "adminform", toolbarIcon = "/com/hccs/sample/resources/_16x16/studentreportcard.png", text = "Admin Form")
@ActionPaths({ @ActionPath(path = "Scenes", position = 2, location = ActionLocation.TOOLBAR) })

public class AdminFormActionHandler extends ActionHandler {
	@Override
	public void handle(ActionEvent event) {
		System.out.println("Loading Employee Details Window....");
//		Context.initialize();
		Context.lookup("StudentModuleConfig", StudentModuleConfig.class);
		StudentForm student = Context.getBean(StudentForm.class);
		student.show();
		
		Context.lookup("EmployeeModuleConfig", EmployeeModuleConfig.class);
		EmployeeForm employee = Context.getBean(EmployeeForm.class);
		employee.show();
	}
}
