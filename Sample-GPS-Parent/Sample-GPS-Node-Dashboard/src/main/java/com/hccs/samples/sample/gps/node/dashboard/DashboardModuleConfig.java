package com.hccs.samples.sample.gps.node.dashboard;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.hccs.samples.sample.gps.node.form", "com.hccs.samples.sample.gps.node.gateway" })
public class DashboardModuleConfig {

}