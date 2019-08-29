package com.hccs.samples.sample.gps.models.beans;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class EmployeeBean {
	public String firstName;
	public String lastName;
	
	public List<EmployeePositionBean> position;
	
	public EmployeeBean(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return lastName + ", " + firstName;
	}
}
