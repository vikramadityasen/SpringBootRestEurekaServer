package com.springboot.eureka.creditscorestubservice.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.eureka.creditscorestubservice.model.CreditDetails;
import com.springboot.eureka.creditscorestubservice.service.CreditScoreStubService;

@RestController
@RequestMapping("/api")
public class CreditScoreStubController {

	@Autowired
	CreditScoreStubService creditScoreService;

	@GetMapping("/getCreditScore")
	public CreditDetails getCreditScore(@RequestParam(name = "ssn", required = true) String ssn,
			@RequestParam(name = "name", required = true) String name,
			@RequestParam(name = "dob", required = true) String dob) {
		return creditScoreService.getCreditScore(ssn, name, dob);
	}
}
