package com.springboot.eureka.creditscoreservice.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
	CreditScoreValidator creditScoreValidator;

	private static final Logger LOGGER = LoggerFactory.getLogger(CreditScoreServiceImpl.class);

	@Override
	public CreditDetails getCreditScore(String ssn, String name, String dob) {

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(EurekaConstants.STUB_API_URL)
				.queryParam("ssn", ssn).queryParam("name", name).queryParam("dob", dob);
		LOGGER.debug("doStuff needed to debug - {}", builder);
		RestTemplate restTemplate = new RestTemplate();
		CreditDetails response = restTemplate.getForObject(builder.toUriString(), CreditDetails.class);
		if (response.getStatusCode().equals(EurekaConstants.SUCCESS_CODE)) {
			response.setCreditGroup(creditScoreValidator.getCreditScoreGroup(response.getCreditScore().getScore()));
		}
		LOGGER.debug("CreditScore Response: {}", response);
		return response;
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
