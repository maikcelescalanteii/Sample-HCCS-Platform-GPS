package com.hccs.samples.sample.gps.node.admin.settings.list;

import com.hccs.samples.sample.gps.models.beans.EmployeePositionBean;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Adapter {
	private final StringProperty lastName;
	private final StringProperty firstName;
	
//	List<GradesBean> grades;
	
	private final ListProperty <EmployeePositionBean> position;
	
	
	public Adapter() {
		lastName = new SimpleStringProperty();
		firstName = new SimpleStringProperty();
		position = new SimpleListProperty<EmployeePositionBean>();
	}

	public StringProperty firstNameProperty() {
		return firstName;
	}
	
	public StringProperty lastNameProperty() {
		return lastName;
	}
	
	public ListProperty <EmployeePositionBean> positionProperty() {
		return position;
	}
	
	@Override
	public String toString() {
		return lastName.get() + ", " + firstName.get();
	}
}
