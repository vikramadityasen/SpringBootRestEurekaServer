package com.springboot.eureka.creditscoreservice.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

	//@GetMapping("/getCreditScore")
	@RequestMapping(value = "/getCreditScore", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
	//@HystrixCommand(fallbackMethod="getDataFallback")
	public CreditDetails getCreditScore(@RequestParam(name = "ssn", required = true) String ssn,
			@RequestParam(name = "name", required = true) String name,
			@RequestParam(name = "dob", required = true) String dob) {
		return creditScoreService.getCreditScore(ssn, name, dob);
	}

	public CreditDetails getDataFallback(String ssn, String name, String dob) {
		CreditScore creditScore = new CreditScore("", "", "", 0);
		return new CreditDetails(creditScore, "", EurekaConstants.SERVICE_NOT_AVAILABLE_CODE,
				ResponseMessage.SERVICE_NOT_AVAILABLE);
	}
}
