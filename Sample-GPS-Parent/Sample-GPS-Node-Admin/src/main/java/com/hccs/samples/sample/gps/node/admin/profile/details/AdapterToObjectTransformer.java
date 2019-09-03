package com.hccs.samples.sample.gps.node.admin.profile.details;

import org.springframework.stereotype.Component;

import com.hccs.samples.sample.gps.core.TransformerBase;
import com.hccs.samples.sample.gps.models.beans.EmployeeBean;
import com.hccs.samples.sample.gps.node.admin.profile.list.Adapter;

@Component
public class AdapterToObjectTransformer extends TransformerBase<Adapter, EmployeeBean> {

	@Override
	public EmployeeBean transform(Adapter obj) {
		// TODO Auto-generated method stub
	System.out.println("ObjectToAdapterTransformer, transform method");
	EmployeeBean employeeBean = new EmployeeBean(obj.firstNameProperty().toString(), obj.lastNameProperty().toString());
//	StudentBean studentBean = new StudentBean();
	employeeBean.firstName = obj.firstNameProperty().getValue();
	employeeBean.lastName = obj.lastNameProperty().getValue();
	employeeBean.position = obj.positionProperty().getValue();
	System.out.println(employeeBean.lastName);
//	studentBean.grades = obj.gradesProperty().getValue();
//	StudentBean.nameProperty().set(obj.lastName + ", " + obj.firstName);
	System.out.println(obj.lastNameProperty().getValue());
	System.out.println(obj.positionProperty().getValue());
	return employeeBean;
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
