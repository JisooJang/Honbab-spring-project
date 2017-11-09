package org.springframework.samples.honbab.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.honbab.domain.Menu;
import org.springframework.samples.honbab.domain.Order;
import org.springframework.samples.honbab.domain.Product;
import org.springframework.samples.honbab.domain.Reservation;
import org.springframework.samples.honbab.restapi.response.OrderApproveResponse;
import org.springframework.samples.honbab.restapi.response.OrderReadyResponse;
import org.springframework.samples.honbab.service.OrderService;
import org.springframework.samples.honbab.service.OrderValidator;
import org.springframework.samples.honbab.service.PetStoreFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

@Controller
@SessionAttributes({"userSession", "order"})
public class OrderFormController {
	
	private static RestTemplate restTemplate = new RestTemplate();
	private String url;
	private String admin_key = "32a0288f2bb831fabade5e6ac9221102";
	private String pg_token;
	private static int index = 1;
	OrderReadyResponse body;	//결제준비API에서의 응답 객체(json)
	
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
	
	@RequestMapping("/oauth")
	public String o_auth() {
		return "order/oauth";
	}
	
	@RequestMapping(value="/orderform/{rest_id}", method=RequestMethod.GET)
	public String get_orderForm(@PathVariable int rest_id, Model model) {
		
		List<Menu> menu = service.getMenuByRestr(rest_id);
		Product restr = service2.getRestr(rest_id);
		
		model.addAttribute("menu", menu);
		model.addAttribute("orderCommand", new OrderCommand());
		model.addAttribute("rest_id", rest_id);
		model.addAttribute("rest_name", restr.getRest_name());
		
		return "order/orderForm";
	}
	
	@RequestMapping(value="/orderform/{rest_id}", method=RequestMethod.POST)
	public String orderform_submit(@PathVariable int rest_id,
			@ModelAttribute("userSession") UserSession userSession,
			@ModelAttribute("orderCommand") OrderCommand orderCommand,
			BindingResult result, Model model) {
		
		url = "https://kapi.kakao.com/v1/payment/ready";
		String user_id = userSession.getAccount().getUser_id();
		int total;
		Menu menu;
		String menu_name, rest_name;
		Order order;
		Product product;
		
		Date d = new Date(System.currentTimeMillis()); 
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd-"); 
		String dt = sf.format(d) + index;

		validator.validate(orderCommand, result);
		if (result.hasErrors()) return "order/orderForm";

		order = orderCommand.getOrder();
		menu = service.getMenu(order.getMenu_id());
		total = menu.getPrice() * order.getQuantity();
		menu_name = menu.getMenu_name();
		product = service2.getRestr(rest_id);
		
		order.setRest_id(rest_id);
		order.setUser_id(user_id);
		order.setSum(total);
		order.setCard_number("0000000000000000");	//임시값 저장
		order.setMenu_id(order.getMenu_id());
		
		
		order.setMenu_name(menu_name);
		order.setRest_name(product.getRest_name());
		order.setPartner_order_id(dt);
		index++;
		
		service.insertOrder(order);
		
		model.addAttribute("order", order);	//세션에 주문 정보 저장
		
		model.addAttribute("menu_name", menu_name);
		
		String user_phone = userSession.getAccount().getPhone();
		
		MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<>();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
		headers.add("Authorization", "KakaoAK " + admin_key);
		
		HttpEntity<MultiValueMap<String, Object>> requestObject =
				new HttpEntity<>(parameters, headers);

		parameters.add("cid", "TC0ONETIME");	//실제 가맹점과 제휴가 이루어져야 cid 설정 가능. 현재는 test값 사용
		parameters.add("partner_order_id", order.getPartner_order_id());
		parameters.add("partner_user_id", user_id);
		parameters.add("item_name", menu_name);
		parameters.add("quantity", String.valueOf(order.getQuantity()));
		parameters.add("total_amount", String.valueOf(order.getSum()));
		parameters.add("tax_free_amount", "0");
		parameters.add("vat_amount", "0");
		parameters.add("approval_url", "http://202.20.119.117/Honbab/order_completed");
		parameters.add("cancel_url", "http://202.20.119.117/Honbab/order_canceled");
		parameters.add("fail_url", "http://202.20.119.117/Honbab/order_failed");
		parameters.add("user_phone_number", user_phone);
		
		ResponseEntity<OrderReadyResponse> response  = restTemplate.exchange(url, HttpMethod.POST,
				requestObject, OrderReadyResponse.class);
		this.body = response.getBody();
		model.addAttribute("body2", body);
		
		return "redirect:" + body.getNext_redirect_pc_url();
	}
	
	@RequestMapping("/order_completed")
	public String approve_order(HttpServletRequest request) {
		this.pg_token = request.getParameter("pg_token");
		return "order/order_completed";
	}
	
	@RequestMapping("/request_order_approval")
	public String approve_api_call(@ModelAttribute("userSession") UserSession userSession,
			@ModelAttribute("order") Order order, Model model) {
		
		url = "https://kapi.kakao.com/v1/payment/approve";
		MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<>();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
		headers.add("Authorization", "KakaoAK " + admin_key);
		
		HttpEntity<MultiValueMap<String, Object>> requestObject =
				new HttpEntity<>(parameters, headers);
		
		parameters.add("cid", "TC0ONETIME");	//실제 가맹점과 제휴가 이루어져야 cid 설정 가능. 현재는 test값 사용
		parameters.add("tid	", this.body.getTid());
		parameters.add("partner_order_id", order.getPartner_order_id());
		parameters.add("partner_user_id", userSession.getAccount().getUser_id());
		parameters.add("pg_token", pg_token);
		
		/*ResponseEntity<OrderApproveResponse> response  = restTemplate.exchange(url, HttpMethod.POST,
				requestObject, OrderApproveResponse.class);	
		OrderApproveResponse body = response.getBody();
		
		model.addAttribute("approval_body", body);*/
		
		model.addAttribute("tid", this.body.getTid());
		model.addAttribute("partner_order_id", order.getPartner_order_id());
		model.addAttribute("pg_token", pg_token);
		
		
		return "order/order_approved";
	}
	
	@RequestMapping("/order_canceled")
	public String cancel_order() {
		return "order/order_canceled";
	}
	
	@RequestMapping("/order_failed")
	public String fail_order() {
		return "order/order_failed";
	}
	
}
