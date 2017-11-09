package org.springframework.samples.honbab.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.honbab.domain.Product;
import org.springframework.samples.honbab.service.PetStoreFacade;
import org.springframework.samples.honbab.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("restr2")
public class MainController {
	
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
	
	@RequestMapping("/shop/index.do")
	public String get_restr_top3(Model model) {
		List<Integer> rest_id_list = service.getRest_id_list_in_reservation();
		int i = 0, j = 0, k = -1;
		int count = 0;
		int max = 0;
		int rest_id = 0;

		List<Product> restr = new ArrayList<Product>();
		Product temp;
		List<Product> restr2 = new ArrayList<Product>();
		
		for(i=0 ; i<rest_id_list.size() ; i++) {
			//System.out.println(rest_id_list.get(i).intValue());
			rest_id = rest_id_list.get(i).intValue();
			count = service.get_rest_count(rest_id);
			
			temp = service2.getRestr(rest_id);
			temp.setReservation_count(count);
			
			restr.add(temp);		
		}
		
		for(i=0 ; i<3 ; i++) {
			for(j=0 ; j<restr.size() ; j++) {
				if(max < restr.get(j).getReservation_count()) {
					max = restr.get(j).getReservation_count();
					System.out.println(restr.get(j).getRest_id());
					k = j;
				}
			}
			max = 0;
			restr.get(k).setReservation_count(0);
			restr2.add(restr.get(k));
		}	
		
		
		for(i=0 ; i<restr2.size() ; i++) {
			System.out.println(restr2.get(i).getRest_id());
		}
		
		model.addAttribute("restr2", restr2);
		
		return "index";
	}

}
