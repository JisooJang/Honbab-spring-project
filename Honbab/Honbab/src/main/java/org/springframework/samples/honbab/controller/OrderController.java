package org.springframework.samples.honbab.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.honbab.domain.Menu;
import org.springframework.samples.honbab.domain.Order;
import org.springframework.samples.honbab.domain.Product;
import org.springframework.samples.honbab.service.OrderService;
import org.springframework.samples.honbab.service.OrderValidator;
import org.springframework.samples.honbab.service.PetStoreFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("userSession")
@RequestMapping("shop/mypage")
public class OrderController {

	@Autowired
	OrderService service;
	public void setService(OrderService service) {
		this.service = service;
	}
	
	@Autowired
	PetStoreFacade service2;
	public void setService2(PetStoreFacade service2) {
		this.service2 = service2;
	}

	@Autowired
	OrderValidator validator;
	public void setValidator(OrderValidator validator) {
		this.validator = validator;
	}
	
	@RequestMapping("/ticketList")
	public String get_ticket_list(@ModelAttribute("userSession") UserSession userSession,
			Model model) {
		int i = 0;
		int rest_id, menu_id;
		List<Order> orders = new ArrayList<Order>();
		orders = service.get_ticket_list(userSession.getAccount().getUser_id());
		
		for(i=0 ; i<orders.size() ; i++) {
			rest_id = orders.get(i).getRest_id();
			menu_id = orders.get(i).getMenu_id();
			orders.get(i).setRest_name(service2.getRestr(rest_id).getRest_name());
			orders.get(i).setMenu_name(service.getMenu(menu_id).getMenu_name());
		}
		
		model.addAttribute("orders", orders);

		return "order/mypage_orderList";
		
	}
	
	@RequestMapping("/cancel_ticket/{ticket_id}")
	public String cancel_ticket(@PathVariable("ticket_id") int ticket_id) {
		
		service.cancelOrder(ticket_id);
		return "redirect:/shop/mypage/ticketList";
	}
	
	@RequestMapping("/ticket_details/{ticket_id}")
	public String ticket_details() {
		return "order/ticket_details";
	}
}
