package com.springboot.eureka.creditscoreservice.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.eureka.creditscoreservice.constant.EurekaConstants;
import com.springboot.eureka.creditscoreservice.model.CreditDetails;
import com.springboot.eureka.creditscoreservice.model.CreditScore;
import com.springboot.eureka.creditscoreservice.responsemessage.ResponseMessage;
import com.springboot.eureka.creditscoreservice.service.CreditScoreService;

@RestController
@RequestMapping("/api")
public class CreditScoreController {

	@Autowired
	CreditScoreService creditScoreService;

	@GetMapping("/getCreditScore")
	public CreditDetails getCreditScore(@RequestParam(name = "ssn", required = true) String ssn,
			@RequestParam(name = "name", required = true) String name,
			@RequestParam(name = "dob", required = true) String dob) {
		return creditScoreService.getCreditScore(ssn, name, dob);
	}

	public CreditDetails getDataFallback(String ssn, String name, String dob) {
		CreditScore creditScore = new CreditScore();
		return new CreditDetails(creditScore, "", EurekaConstants.SERVICE_NOT_AVAILABLE_CODE,
				ResponseMessage.SERVICE_NOT_AVAILABLE);
	}
}
