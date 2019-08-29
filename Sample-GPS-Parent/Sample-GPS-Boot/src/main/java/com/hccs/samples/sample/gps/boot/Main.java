package com.hccs.samples.sample.gps.boot;

import com.hccs.platform.PlatformApplication;
import com.hccs.samples.sample.gps.node.StudentModuleConfig;
import com.hccs.samples.sample.gps.node.form.StudentForm;
import com.hccs.samples.sample.gps.node.form._StudentForm;

import javafx.application.Application;

public class Main {

	public static void main(String[] args) {
		System.out.println("Main method, Boot Project");
//		Main main = new Main();
//		main.showNodeForm();

		Application.launch(PlatformApplication.class);
	}

//	public void showNodeForm() {
//		Context.initialize();
//		Context.lookup("NodeModuleConfig", ModuleConfig.class);
//		NodeForm form = Context.getBean(NodeForm.class);
//		form.show();
//		
//	}
}
