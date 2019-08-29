package com.hccs.samples.sample.gps.models;

import java.util.ArrayList;
import java.util.List;

import com.hccs.samples.sample.gps.models.beans.EmployeeBean;
import com.hccs.samples.sample.gps.models.beans.EmployeePositionBean;

public class EmployeeModel {

	private static List<EmployeeBean> employees;

	public static List<EmployeeBean> getEmployees() {
		if (employees == null) {
			employees = new ArrayList<EmployeeBean>();
		}
		return employees;
	}

	public static void initialize() {
		EmployeeBean s1 = new EmployeeBean("Juan", "Dela Cruz");
		List<EmployeePositionBean> e1_list = new ArrayList<EmployeePositionBean>();
		e1_list.add(new EmployeePositionBean("Angeles City", "Male", 25000));
		s1.position = e1_list;

		EmployeeBean s2 = new EmployeeBean("Pedro", "Santa Ana");
		List<EmployeePositionBean> e2_list = new ArrayList<EmployeePositionBean>();
		e2_list.add(new EmployeePositionBean("San Fernando City", "Male", 27000));
		s2.position = e2_list;

		EmployeeBean s3 = new EmployeeBean("Fernando", "Rodriguez");
		List<EmployeePositionBean> e3_list = new ArrayList<EmployeePositionBean>();
		e3_list.add(new EmployeePositionBean("Mexico", "Male", 20000));
		s3.position = e3_list;

		System.out.println("Starting to add.");
		getEmployees().add(s1);
		getEmployees().add(s2);
		getEmployees().add(s3);
		System.out.println("Successfully added.");
	}
}
