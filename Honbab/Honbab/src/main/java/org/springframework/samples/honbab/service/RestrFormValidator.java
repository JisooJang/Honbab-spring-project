package org.springframework.samples.honbab.service;


import org.springframework.samples.honbab.controller.RestrForm;
import org.springframework.samples.honbab.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class RestrFormValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		RestrForm restrForm = (RestrForm)obj; 
		Product restr = restrForm.getRestr();

		
		/*ValidationUtils.rejectIfEmptyOrWhitespace(errors, "restr.rest_name", "NAME_REQUIRED", "name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.rest_address", "ADDRESS_REQUIRED", "address is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.rest_phone", "PHONE_REQUIRED", "Phone number is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.rest_time", "TIME_REQUIRED", "time is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.rest_seat", "SEAT_REQUIRED", "seat is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.rest_bankcode", "BANKCODE_REQUIRED", "bankcode is required.");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.rest_account", "ACCOUNT_REQUIRED", "account is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.rest_ctg", "CATEGORY_REQUIRED", "category is required.");*/
		
		
	}
}

