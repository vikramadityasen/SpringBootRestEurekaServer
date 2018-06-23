package com.springboot.eureka.creditscoreservice.service;

import com.springboot.eureka.creditscoreservice.model.CreditDetails;

public interface CreditScoreService {

	public CreditDetails getCreditScore(String ssn, String name, String dob);
}
