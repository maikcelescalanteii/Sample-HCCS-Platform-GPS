package com.hccs.samples.sample.gps.boot.actions.handles;

import com.hccs.platform.annotations.Action;
import com.hccs.platform.annotations.ActionPath;
import com.hccs.platform.annotations.ActionPaths;
import com.hccs.platform.enums.ActionLocation;
import com.hccs.platform.extendables.ActionHandler;
import com.hccs.samples.sample.gps.boot.Context;
import com.hccs.samples.sample.gps.node.employee.EmployeeModuleConfig;
import com.hccs.samples.sample.gps.node.employee.form.EmployeeForm;

import javafx.event.ActionEvent;
@Action(name = "employeedetail", toolbarIcon = "/com/hccs/sample/resources/_16x16/studentreportcard.png", text = "Employee Detail")
@ActionPaths({ @ActionPath(path = "Scenes", position = 1, location = ActionLocation.TOOLBAR) })

public class EmployeeFormActionHandler extends ActionHandler {
	@Override
	public void handle(ActionEvent event) {
		System.out.println("Loading Employee Details Window....");
		Context.initialize();
		Context.lookup("EmployeeModuleConfig", EmployeeModuleConfig.class);
		EmployeeForm form = Context.getBean(EmployeeForm.class);
		form.show();
	}
}
