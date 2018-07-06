package com.springboot.eureka.creditscoreservice.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springboot.eureka.creditscoreservice.constant.EurekaConstants;
import com.springboot.eureka.creditscoreservice.model.CreditDetails;
import com.springboot.eureka.creditscoreservice.model.CreditScore;
import com.springboot.eureka.creditscoreservice.responsemessage.ResponseMessage;
import com.springboot.eureka.creditscoreservice.service.CreditScoreService;
import com.springboot.eureka.creditscoreservice.serviceImpl.CreditScoreServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "CreditScore Application")
public class CreditScoreController {

	@Autowired
	CreditScoreService creditScoreService;

	private static final Logger LOGGER = LoggerFactory.getLogger(CreditScoreServiceImpl.class);

	@ApiOperation(value= "Credit Score details", notes = "Get user details with credit score and group")

	@GetMapping("/getCreditScore")
	// @RequestMapping(value = "/getCreditScore", produces =
	// MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "getDataFallback")
	public CreditDetails getCreditScore(@RequestParam(name = "ssn", required = true) String ssn,
			@RequestParam(name = "name", required = true) String name,
			@RequestParam(name = "dob", required = true) String dob) {
		LOGGER.debug(String.format("Request Parameters: {}", ssn, name, dob));
		return creditScoreService.getCreditScore(ssn, name, dob);
	}

	public CreditDetails getDataFallback(String ssn, String name, String dob) {
		CreditScore creditScore = new CreditScore("", "", "", 0);
		LOGGER.debug("Credit Details: {}", ssn, name, dob);
		return new CreditDetails(creditScore, "", EurekaConstants.SERVICE_NOT_AVAILABLE_CODE,
				ResponseMessage.SERVICE_NOT_AVAILABLE);
	}
}
