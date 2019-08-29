package com.hccs.samples.sample.gps.node.employee;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.hccs.samples.sample.gps.node.employee.form", "com.hccs.samples.sample.gps.node.employee.gateway" })
public class EmployeeModuleConfig {

}
