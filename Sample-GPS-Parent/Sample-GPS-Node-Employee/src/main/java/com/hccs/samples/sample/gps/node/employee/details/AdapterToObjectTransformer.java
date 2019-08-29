package com.hccs.samples.sample.gps.node.employee.details;

import org.springframework.stereotype.Component;

import com.hccs.samples.sample.gps.core.TransformerBase;
import com.hccs.samples.sample.gps.models.beans.StudentBean;
import com.hccs.samples.sample.gps.node.employee.list.Adapter;

@Component
public class AdapterToObjectTransformer extends TransformerBase<Adapter, StudentBean> {

	@Override
	public StudentBean transform(Adapter obj) {
		// TODO Auto-generated method stub
	System.out.println("ObjectToAdapterTransformer, transform method");
	StudentBean studentBean = new StudentBean(obj.firstNameProperty().toString(), obj.lastNameProperty().toString());
//	StudentBean studentBean = new StudentBean();
	studentBean.firstName = obj.firstNameProperty().getValue();
	studentBean.lastName = obj.lastNameProperty().getValue();
	studentBean.grades = obj.gradesProperty().getValue();
//	studentBean.grades = obj.gradesProperty().getValue();
//	StudentBean.nameProperty().set(obj.lastName + ", " + obj.firstName);
	System.out.println(obj.lastNameProperty().getValue());
	System.out.println(obj.gradesProperty().getValue());
	return studentBean;
	}



//	@Override
//	public StudentBean transform(Adapter obj) {
////		System.out.println("ObjectToAdapterTransformer, transform method");
//		StudentBean studentBean = new StudentBean();
////		StudentBean.nameProperty().set(obj.lastName + ", " + obj.firstName);
////		System.out.println(obj.lastName);
//		return studentBean;
//	}
//
//	@Override
//	public Adapter transform(StudentBean obj) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
