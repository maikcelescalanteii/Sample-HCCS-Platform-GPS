package com.hccs.samples.sample.gps.models.beans;

public class EmployeePositionBean {
	public float salary;
	public String address;
	public String gender;

	public EmployeePositionBean(String address, String gender, float salary) {
		this.address = address;
		this.gender = gender;
		this.salary = salary;
	}

	public String getRemarks() {
		return salary < 25000 ? "Assoc. Sys Dev" : "Sys Dev";
	}

}
