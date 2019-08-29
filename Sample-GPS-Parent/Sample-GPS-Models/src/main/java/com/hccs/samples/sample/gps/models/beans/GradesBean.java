package com.hccs.samples.sample.gps.models.beans;

public class GradesBean {
	public float grade;
	public String subject;

	public GradesBean(String subject, float grade) {
		this.subject = subject;
		this.grade = grade;
	}

	public String getRemarks() {
		return grade < 75 ? "Failed" : "Passed";
	}

}
