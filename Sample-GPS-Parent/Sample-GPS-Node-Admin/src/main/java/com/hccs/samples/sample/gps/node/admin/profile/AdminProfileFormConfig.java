package com.hccs.samples.sample.gps.node.admin.profile;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.hccs.platform.HCCSPlatform;
import com.hccs.samples.sample.gps.core.annotations.GlassBean;
import com.hccs.samples.sample.gps.node.admin.profile.window.AdminProfileWindowGlass;
import com.hccs.samples.sample.gps.node.admin.profile.window._AdminProfileWindowGlass;

@Configuration
@ComponentScan(basePackages = { "com.hccs.samples.sample.gps.node.admin.profile.window", "com.hccs.samples.sample.gps.node.admin.profile.details",
		"com.hccs.samples.sample.gps.node.admin.profile.list" })
public class AdminProfileFormConfig {

	@GlassBean
	public AdminProfileWindowGlass adminProfileWindowGlass() {
		// If you're using platform, do this with your top window glass, otherwise, just
		// annotate with @glass the glass implementation and delete this method.
		//
		return (AdminProfileWindowGlass)
		HCCSPlatform.getWindowService().newInstance(_AdminProfileWindowGlass.class );

		//return new _WindowGlass();
	}
}
