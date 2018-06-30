package com.springboot.eureka.creditscorestubservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.eureka.creditscorestubservice.model.CreditDetails;
import com.springboot.eureka.creditscorestubservice.service.CreditScoreStubService;
import com.springboot.eureka.creditscorestubservice.util.CreditScoreStubUtil;

@Service
public class CreditScoreStubServiceImpl implements CreditScoreStubService {

	@Autowired
	CreditScoreStubUtil creditScoreStubUtil;

	@Override
	public CreditDetails getCreditScore(String ssn, String name, String dob) {
		return creditScoreStubUtil.getCreditScore(ssn, name, dob);
	}

}
