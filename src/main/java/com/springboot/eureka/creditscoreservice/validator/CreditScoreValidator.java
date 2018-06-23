package com.springboot.eureka.creditscoreservice.validator;

import org.springframework.stereotype.Component;

@Component
public class CreditScoreValidator {

	public String getCreditScoreGroup(Integer creditScore) {
		if (creditScore >= 750) {
			return "EXCELLENT";
		} else if (creditScore < 750 && creditScore >= 700) {
			return "GOOD";
		} else if (creditScore < 700 && creditScore >= 650) {
			return "FAIR";
		} else if (creditScore < 650 && creditScore >= 550) {
			return "POOR";
		} else {
			return "BAD";
		}
	}
}
