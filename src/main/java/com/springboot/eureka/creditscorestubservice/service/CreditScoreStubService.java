package com.springboot.eureka.creditscorestubservice.service;

import com.springboot.eureka.creditscorestubservice.model.CreditDetails;

public interface CreditScoreStubService {

	public CreditDetails getCreditScore(String ssn, String name, String dob);
}
