package com.springboot.eureka.creditscorestubservice.model;

public class CreditScore {

	private String ssn;
	private String name;
	private String dob;
	private Integer score;

	public CreditScore() {
	}

	public CreditScore(String ssn, String name, String dob, Integer score) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.dob = dob;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}
