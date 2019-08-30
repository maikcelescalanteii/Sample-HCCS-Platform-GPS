package com.hccs.samples.sample.gps.node.admin.settings;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.hccs.platform.HCCSPlatform;
import com.hccs.samples.sample.gps.core.annotations.GlassBean;
import com.hccs.samples.sample.gps.node.admin.settings.window.AdminSettingsWindowGlass;
import com.hccs.samples.sample.gps.node.admin.settings.window._AdminSettingsWindowGlass;

@Configuration
@ComponentScan(basePackages = { "com.hccs.samples.sample.gps.node.admin.settings.window", "com.hccs.samples.sample.gps.node.admin.settings.details",
		"com.hccs.samples.sample.gps.node.admin.settings.list" })
public class AdminSettingsFormConfig {

	@GlassBean
	public AdminSettingsWindowGlass adminWindowGlass() {
		// If you're using platform, do this with your top window glass, otherwise, just
		// annotate with @glass the glass implementation and delete this method.
		//
		return (AdminSettingsWindowGlass)
		HCCSPlatform.getWindowService().newInstance(_AdminSettingsWindowGlass.class );

		//return new _WindowGlass();
	}
}
