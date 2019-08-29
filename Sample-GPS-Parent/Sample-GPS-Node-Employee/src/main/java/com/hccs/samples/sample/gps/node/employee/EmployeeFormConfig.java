package com.hccs.samples.sample.gps.node.employee;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.hccs.platform.HCCSPlatform;
import com.hccs.samples.sample.gps.core.annotations.GlassBean;
import com.hccs.samples.sample.gps.node.employee.window.EmployeeWindowGlass;
import com.hccs.samples.sample.gps.node.employee.window._EmployeeWindowGlass;

@Configuration
@ComponentScan(basePackages = { "com.hccs.samples.sample.gps.node.employee.window", "com.hccs.samples.sample.gps.node.employee.details",
		"com.hccs.samples.sample.gps.node.employee.list" })
public class EmployeeFormConfig {

	@GlassBean
	public EmployeeWindowGlass employeeWindowGlass() {
		// If you're using platform, do this with your top window glass, otherwise, just
		// annotate with @glass the glass implementation and delete this method.
		//
		return (EmployeeWindowGlass)
		HCCSPlatform.getWindowService().newInstance(_EmployeeWindowGlass.class );

		//return new _WindowGlass();
	}
}
