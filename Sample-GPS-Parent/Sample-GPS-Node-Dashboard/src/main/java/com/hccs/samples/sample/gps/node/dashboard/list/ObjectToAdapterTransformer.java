package com.hccs.samples.sample.gps.node.dashboard.list;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hccs.samples.sample.gps.core.TransformerBase;
import com.hccs.samples.sample.gps.models.beans.GradesBean;
import com.hccs.samples.sample.gps.models.beans.StudentBean;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@Component
public class ObjectToAdapterTransformer extends TransformerBase<StudentBean, DashboardAdapter> {

	@Override
	public DashboardAdapter transform(StudentBean obj) {
		
		ObservableList<GradesBean> observableList = FXCollections.observableList(obj.grades);
		
		System.out.println("ObjectToAdapterTransformer, transform method");
		System.out.println(obj.lastName);
		DashboardAdapter adapter = new DashboardAdapter();
		adapter.firstNameProperty().set(obj.firstName);
		adapter.lastNameProperty().set(obj.lastName);
		System.out.println(observableList);
		adapter.gradesProperty().set(observableList);
//		adapter.gradesProperty().setAll(obj.grades);
		return adapter;
	}

}
