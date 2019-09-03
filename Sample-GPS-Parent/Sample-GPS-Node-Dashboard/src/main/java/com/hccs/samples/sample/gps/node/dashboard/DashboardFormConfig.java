package com.hccs.samples.sample.gps.node.dashboard;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.hccs.platform.HCCSPlatform;
import com.hccs.samples.sample.gps.core.annotations.GlassBean;
import com.hccs.samples.sample.gps.node.dashboard.window.DashboardWindowGlass;
import com.hccs.samples.sample.gps.node.dashboard.window._DashboardWindowGlass;

@Configuration
@ComponentScan(basePackages = { "com.hccs.samples.sample.gps.node.dashboard.window", "com.hccs.samples.sample.gps.node.dashboard.details",
		"com.hccs.samples.sample.gps.node.dashboard.list" })
public class DashboardFormConfig {

	@GlassBean
	public DashboardWindowGlass studentWindowGlass() {
		// If you're using platform, do this with your top window glass, otherwise, just
		// annotate with @glass the glass implementation and delete this method.
		//
		return (DashboardWindowGlass)
		HCCSPlatform.getWindowService().newInstance(_DashboardWindowGlass.class );

		//return new _WindowGlass();
	}
}
