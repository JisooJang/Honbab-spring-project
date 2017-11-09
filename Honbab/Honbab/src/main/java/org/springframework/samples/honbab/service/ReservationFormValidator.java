package org.springframework.samples.honbab.service;

import org.springframework.samples.honbab.controller.ReservationCommand;
import org.springframework.samples.honbab.domain.Reservation;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class ReservationFormValidator implements Validator{

	public ReservationFormValidator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Reservation.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		ReservationCommand command = (ReservationCommand)obj; 
		Reservation reservation = command.getReservation();
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reservation.numOfPeople", "NUMOFPEOPLE_REQUIRED", "num of people is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reservation.visit_date", "VISIT_DATE_REQUIRED", "visit date is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reservation.visit_time", "VISIT_TIME_REQUIRED", "visit time is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reservation.name", "NAME_REQUIRED", "name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reservation.phone", "PHONE_REQUIRED", "Phone number is required.");

		
	}

}
