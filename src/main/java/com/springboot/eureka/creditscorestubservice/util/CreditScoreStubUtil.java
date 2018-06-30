package com.springboot.eureka.creditscorestubservice.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.springboot.eureka.creditscorestubservice.model.CreditDetails;
import com.springboot.eureka.creditscorestubservice.model.CreditScore;
import com.springboot.eureka.creditscorestubservice.responsemessage.ResponseMessage;
@Component
public class CreditScoreStubUtil {

	static Map<String, CreditScore> creditScoreLists = new HashMap<>();

	static {
		try {
			creditScoreLists.put("123-45-6789", new CreditScore("123-45-6789","vikram", "11-01-1990", 720));
			creditScoreLists.put("123-45-7896", new CreditScore("123-45-7896","rohit", "12-02-1991", 650));
			creditScoreLists.put("123-45-8967", new CreditScore("123-45-8967","birju", "13-03-1992", 620));
			creditScoreLists.put("123-45-9678", new CreditScore("123-45-9678","aditya", "14-04-1993", 550));
			creditScoreLists.put("123-45-9867", new CreditScore("123-45-9867","ashish", "15-05-1994", 520));
		} catch (Exception e) {
			e.getLocalizedMessage();
		}
	}

	public CreditDetails getCreditScore(String ssn, String name, String dob) {
		CreditDetails creditDetails = new CreditDetails();
		CreditScore customerCreditScore = creditScoreLists.get(ssn);
		if (customerCreditScore != null) {
			boolean isNameCorrect = customerCreditScore.getName().equals(name) ? Boolean.TRUE : Boolean.FALSE;
			boolean isDobCorrect = customerCreditScore.getDob().equals(dob) ? Boolean.TRUE : Boolean.FALSE;
			if (isNameCorrect && isDobCorrect) {
				creditDetails.setCreditScore(customerCreditScore);
				creditDetails.setMessage(ResponseMessage.SUCCESS);
				creditDetails.setStatusCode(ResponseMessage.SUCCESS_CODE);
			} else {
				creditDetails.setMessage(ResponseMessage.INVALID_CUSTOMER_DATA);
				creditDetails.setStatusCode(ResponseMessage.INVALID_CUSTOMER_DATA_CODE);
			}
			return creditDetails;
		} else {
			creditDetails.setMessage(ResponseMessage.CUSTOMER_NOT_FOUND);
			creditDetails.setStatusCode(ResponseMessage.CUSTOMER_NOT_FOUND_CODE);
			return creditDetails;
		}
	}
}