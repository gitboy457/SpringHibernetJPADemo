package com.ace.SpringHibernetJPADemo.validation;

import java.util.regex.Pattern;

import com.ace.SpringHibernetJPADemo.request.CustomerRequest;

public class CustomerValidation {

	public static boolean validateMobile(String mobile) {

		if (mobile != null && !mobile.isEmpty() && mobile.matches("\\d{10}")) {
			return true;
		}

		return false;

	}

	public static boolean validateEmail(String email) {

		if (email != null && !email.isEmpty() && email.matches(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			return true;
		}

		return false;
	}

	public static boolean validateCustomerRequest(CustomerRequest customerRequest) {

		if (validateMobile(customerRequest.getMobileNumber()) && validateEmail(customerRequest.getEmailAddress())) {
			return true;
		}

		return false;
	}

}
