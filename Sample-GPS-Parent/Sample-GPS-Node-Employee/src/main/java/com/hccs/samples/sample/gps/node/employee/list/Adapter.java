package com.hccs.samples.sample.gps.node.employee.list;

import java.util.List;

import com.hccs.samples.sample.gps.models.beans.GradesBean;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Adapter {
	private final StringProperty lastName;
	private final StringProperty firstName;
	
//	List<GradesBean> grades;
	
	private final ListProperty <GradesBean> grades;
	
	
	public Adapter() {
		lastName = new SimpleStringProperty();
		firstName = new SimpleStringProperty();
		grades = new SimpleListProperty<GradesBean>();
	}

	public StringProperty firstNameProperty() {
		return firstName;
	}
	
	public StringProperty lastNameProperty() {
		return lastName;
	}
	
	public ListProperty <GradesBean> gradesProperty() {
		return grades;
	}
	
	@Override
	public String toString() {
		return lastName.get() + ", " + firstName.get();
	}
}
