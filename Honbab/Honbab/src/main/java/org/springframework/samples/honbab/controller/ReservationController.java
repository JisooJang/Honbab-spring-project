package org.springframework.samples.honbab.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.honbab.domain.Product;
import org.springframework.samples.honbab.domain.Reservation;
import org.springframework.samples.honbab.service.PetStoreFacade;
import org.springframework.samples.honbab.service.ReservationFormValidator;
import org.springframework.samples.honbab.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/shop/mypage")
public class ReservationController {

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

	public ReservationController() {
		// TODO Auto-generated constructor stub
	}

	public ReservationController(ReservationService service) {
		this.service = service;
	}
	
	@RequestMapping("/reservation")	
	public String mypage_reservation_list(@ModelAttribute("userSession") UserSession userSession, 
			Model model, HttpServletRequest request) {

		int i;
		String rest_name;
		Product restr;
		String user_id = userSession.getAccount().getUser_id();
		List<Reservation> reservation_list = service.get_reservation_list(user_id);
		
		for(i=0 ; i<reservation_list.size() ; i++) {
			restr = service2.getRestr(reservation_list.get(i).getRest_id());
			rest_name = restr.getRest_name();
			reservation_list.get(i).setRest_name(rest_name);
		}
		
		model.addAttribute("reservation_list", reservation_list);
		return "reservation/reserv_list";
	}
	
	@RequestMapping("/reservation_details/{reservation_id}")
	public String mypage_reservation_details(@PathVariable int reservation_id, Model model) {
		
		String rest_name;
		Product restr;

		Reservation reservation = service.get_reservation(reservation_id);
		
		restr = service2.getRestr(reservation.getRest_id());
		rest_name = restr.getRest_name();
		reservation.setRest_name(rest_name);
		
		model.addAttribute("reservation", reservation);
		model.addAttribute("restr", restr);
		return "reservation/reserv_details";
	}


	@RequestMapping(value="/reservation_modify/{reservation_id}", method=RequestMethod.GET)
	public String reservation_modify(@PathVariable int reservation_id, Model model){

		Reservation reservation = service.get_reservation(reservation_id);
		ReservationCommand command = new ReservationCommand(reservation);
		model.addAttribute("reservationCommand", command);
		return "reservation/modify_reservationForm";
	}

	@RequestMapping(value="/reservation_modify/{reservation_id}", method=RequestMethod.POST)
	public String reservation_modify_submit(@PathVariable int reservation_id,
			@ModelAttribute("reservationCommand") ReservationCommand reservationCommand, 
			BindingResult result, @ModelAttribute("userSession") UserSession userSession) {
		
		validator.validate(reservationCommand, result);
		if (result.hasErrors()) return "/reservation/reservationForm";

		Reservation reservation1 = service.get_reservation(reservation_id);
		Reservation reservation2 = reservationCommand.getReservation();

		reservation2.setReservation_id(reservation_id);
		reservation2.setRest_id(reservation1.getRest_id());
		reservation2.setUser_id(reservation1.getUser_id());

		service.updateReservation(reservation2);

		return "redirect:/shop/mypage/reservation";
	}



	@RequestMapping("/reservation_delete/{reservation_id}")
	public String mypage_reservation_delete(@PathVariable int reservation_id, 
			@ModelAttribute("userSession") UserSession userSession) {
		
		service.deleteReservation(reservation_id);
		
		return "redirect:/shop/mypage/reservation";
	}

}
