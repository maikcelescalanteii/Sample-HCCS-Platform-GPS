package com.hccs.samples.sample.gps.node.employee.list;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hccs.samples.sample.gps.core.TransformerBase;
import com.hccs.samples.sample.gps.models.beans.EmployeeBean;
import com.hccs.samples.sample.gps.models.beans.EmployeePositionBean;
import com.hccs.samples.sample.gps.models.beans.GradesBean;
import com.hccs.samples.sample.gps.models.beans.StudentBean;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@Component
public class ObjectToAdapterTransformer extends TransformerBase<EmployeeBean, Adapter> {

	@Override
	public Adapter transform(EmployeeBean obj) {
		
		ObservableList<EmployeePositionBean> observableList = FXCollections.observableList(obj.position);
		
		System.out.println("ObjectToAdapterTransformer, transform method");
		System.out.println(obj.lastName);
		Adapter adapter = new Adapter();
		adapter.firstNameProperty().set(obj.firstName);
		adapter.lastNameProperty().set(obj.lastName);
		System.out.println(observableList);
		adapter.positionProperty().set(observableList);
//		adapter.gradesProperty().setAll(obj.grades);
		return adapter;
	}

}
