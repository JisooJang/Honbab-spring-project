package org.springframework.samples.honbab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.honbab.domain.Product;
import org.springframework.samples.honbab.domain.Reservation;
import org.springframework.samples.honbab.service.PetStoreFacade;
import org.springframework.samples.honbab.service.ReservationFormValidator;
import org.springframework.samples.honbab.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/reservation.do")
public class ReservationFormController {
	
	@Autowired
	ReservationService service;	
	public void setService(ReservationService service) {
		this.service = service;
	}
	
	@Autowired
	PetStoreFacade service2;
	public void setService2(PetStoreFacade service2) {
		this.service2 = service2;
	}

	@Autowired
	private ReservationFormValidator validator;
	public void setValidator(ReservationFormValidator validator) {
		this.validator = validator;
	}
	
	public ReservationFormController(ReservationService service) {
		super();
		this.service = service;
	}
	
	public ReservationFormController() {
		
	}
	
	@RequestMapping(value="/{rest_id}", method=RequestMethod.GET)
	public String reservationForm(@PathVariable int rest_id, 
			@ModelAttribute("userSession") UserSession userSession, Model model) {
		
		if(userSession.getAccount() == null) {
			return "redirect:/shop/searchProducts.do";
		}
		
		Product restr = service2.getRestr(rest_id);
		
		model.addAttribute("reservationCommand", new ReservationCommand());
		model.addAttribute("rest_name", restr.getRest_name());
		return "reservation/reservationForm";
	}


	@RequestMapping(value="/{rest_id}", method=RequestMethod.POST)
	public String reservation_submit(@PathVariable int rest_id, 
			@ModelAttribute("userSession") UserSession userSession,
			@ModelAttribute("reservationCommand") ReservationCommand reservationCommand,
			BindingResult result, Model model) {


		String user_id = userSession.getAccount().getUser_id();

		validator.validate(reservationCommand, result);
		if (result.hasErrors()) return "/reservation/reservationForm";

		Reservation reservation = reservationCommand.getReservation();

		reservation.setRest_id(rest_id);
		reservation.setUser_id(user_id);

		model.addAttribute("reservation", reservation);

		service.insertReservation(reservation);

		return "reservation/reserv_completed";
	}


}
