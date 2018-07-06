package com.springboot.eureka.creditscoreservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.springboot.eureka.creditscoreservice.restcontroller"))
				.paths(regex("/api.*")).build().apiInfo(metaData());
	}

	private ApiInfo metaData() {
		return new ApiInfo("Spring Boot microservices creditScore API", "CreditScore API", "1.0", "Terms of service",
				new Contact("Vikram Aditya Sen", "https://swagger.io/", "sen.vikrama5@gmail.com"),
				"Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0");
	}
}