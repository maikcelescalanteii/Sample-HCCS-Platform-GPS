package com.hccs.samples.sample.gps.node;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.hccs.platform.HCCSPlatform;
import com.hccs.samples.sample.gps.core.annotations.GlassBean;
import com.hccs.samples.sample.gps.node.window.StudentWindowGlass;
import com.hccs.samples.sample.gps.node.window._StudentWindowGlass;

@Configuration
@ComponentScan(basePackages = { "com.hccs.samples.sample.gps.node.window", "com.hccs.samples.sample.gps.node.filter",
		"com.hccs.samples.sample.gps.node.list" })
public class StudentFormConfig {

	@GlassBean
	public StudentWindowGlass studentWindowGlass() {
		// If you're using platform, do this with your top window glass, otherwise, just
		// annotate with @glass the glass implementation and delete this method.
		//
		return (StudentWindowGlass)
		HCCSPlatform.getWindowService().newInstance(_StudentWindowGlass.class );

		//return new _WindowGlass();
	}
}
