package com.springboot.eureka.creditscoreservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.springboot.eureka.creditscoreservice.constant.EurekaConstants;
import com.springboot.eureka.creditscoreservice.model.CreditDetails;
import com.springboot.eureka.creditscoreservice.service.CreditScoreService;
import com.springboot.eureka.creditscoreservice.validator.CreditScoreValidator;

@Service
public class CreditScoreServiceImpl implements CreditScoreService {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	CreditScoreValidator creditScoreValidator;

	@Override
	public CreditDetails getCreditScore(String ssn, String name, String dob) {

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(EurekaConstants.STUB_API_URL)
				.queryParam("SSN", ssn).queryParam("NAME", name).queryParam("DateOfBirth", dob);

		CreditDetails response = restTemplate.getForObject(builder.toUriString(), CreditDetails.class);
		if (response.getStatusCode().equals(EurekaConstants.SUCCESS_CODE)) {
			response.setCreditGroup(creditScoreValidator.getCreditScoreGroup(response.getCreditScore().getScore()));
		}
		return response;
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
