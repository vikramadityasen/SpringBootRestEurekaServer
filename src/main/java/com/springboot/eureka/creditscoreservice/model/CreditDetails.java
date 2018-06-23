package com.springboot.eureka.creditscoreservice.model;

/**
 * 
 * @author vickey
 *
 */
public class CreditDetails {

	private CreditScore creditScore;
	private String creditGroup;
	private Integer statusCode;
	private String message;

	public CreditDetails() {
	}

	public CreditDetails(CreditScore creditScore, String creditGroup, Integer statusCode, String message) {
		super();
		this.creditScore = creditScore;
		this.creditGroup = creditGroup;
		this.statusCode = statusCode;
		this.message = message;
	}

	public CreditScore getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(CreditScore creditScore) {
		this.creditScore = creditScore;
	}

	public String getCreditGroup() {
		return creditGroup;
	}

	public void setCreditGroup(String creditGroup) {
		this.creditGroup = creditGroup;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
