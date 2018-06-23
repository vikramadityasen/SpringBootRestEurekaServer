package com.springboot.eureka.creditscorestubservice.responsemessage;

public class ResponseMessage {
	private ResponseMessage() {

	}

	public static final String SERVICE_NOT_AVAILABLE = "This service is not available right now please try again after some time";
	public static final String SUCCESS = "Success";
	public static final Integer SUCCESS_CODE = 200;
	public static final String INVALID_CUSTOMER_DATA = "Customer is not valid, Please enter valid customer details.";
	public static final Integer INVALID_CUSTOMER_DATA_CODE = 400;
	public static final String CUSTOMER_NOT_FOUND = "This customer is not available";
	public static final Integer CUSTOMER_NOT_FOUND_CODE = 404;
}
