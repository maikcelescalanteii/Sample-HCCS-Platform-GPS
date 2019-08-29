package com.hccs.samples.sample.gps.models;

import java.util.ArrayList;
import java.util.List;

import com.hccs.samples.sample.gps.models.beans.GradesBean;
import com.hccs.samples.sample.gps.models.beans.StudentBean;

public class StudentsModel {

	private static List<StudentBean> students;

	public static List<StudentBean> getStudents() {
		if (students == null) {
			students = new ArrayList<StudentBean>();
		}
		return students;
	}

	public static void initialize() {
		StudentBean s1 = new StudentBean("John", "Doe");
		List<GradesBean> g1_list = new ArrayList<GradesBean>();
		g1_list.add(new GradesBean("English", 74.9f));
		g1_list.add(new GradesBean("Math", 85.0f));
		g1_list.add(new GradesBean("Science", 79.6f));
		g1_list.add(new GradesBean("History", 93.5f));
		s1.grades = g1_list;

		StudentBean s2 = new StudentBean("Robert", "Davis");
		List<GradesBean> g2_list = new ArrayList<GradesBean>();
		g2_list.add(new GradesBean("English", 85.0f));
		g2_list.add(new GradesBean("Math", 81.5f));
		g2_list.add(new GradesBean("Science", 86.3f));
		g2_list.add(new GradesBean("History", 84.1f));
		s2.grades = g2_list;

		StudentBean s3 = new StudentBean("Albert", "Einstein");
		List<GradesBean> g3_list = new ArrayList<GradesBean>();
		g3_list.add(new GradesBean("English", 95.0f));
		g3_list.add(new GradesBean("Math", 99.3f));
		g3_list.add(new GradesBean("Science", 99.9f));
		g3_list.add(new GradesBean("History", 89.7f));
		s3.grades = g3_list;

		getStudents().add(s1);
		getStudents().add(s2);
		getStudents().add(s3);
	}
}
