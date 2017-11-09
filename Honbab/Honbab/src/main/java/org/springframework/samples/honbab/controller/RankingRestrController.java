package org.springframework.samples.honbab.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.honbab.domain.Product;
import org.springframework.samples.honbab.domain.Ranking;
import org.springframework.samples.honbab.service.PetStoreFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class RankingRestrController {
	private PetStoreFacade petStore;

	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	@RequestMapping("/shop/rankingRestr.do")
	public ModelAndView handleRequest(HttpServletRequest request
			) throws Exception {
		
		ModelAndView mav = new ModelAndView("RankingRestr");
	int i=0;	
		List<Ranking> rankingList = new ArrayList<Ranking>(this.petStore.getRanking());
		
		for( i = 0; i < rankingList.size(); i++){
			switch(rankingList.get(i).getRest_ctg())
			{
			case "1":
				rankingList.get(i).setRest_ctg("한식");
				break;
			case "2":
				rankingList.get(i).setRest_ctg("일식");
				break;
			case "3":
				rankingList.get(i).setRest_ctg("중식");
				break;
			case "4":
				rankingList.get(i).setRest_ctg("양식");
				break;
			}
		}
		
	 mav.addObject("rankingList",rankingList);
//		Map map = new HashMap();
//		List<Product> carouselList;
//		List<Product> productList;
//		if (keyword != null) {
//			productList = new ArrayList<Product>(this.petStore.searchProductList(keyword.toLowerCase()));
//		}
//		else {
//			productList = new ArrayList<Product>(this.petStore.searchProductList(""));
//		}
//		
//		request.getSession().setAttribute("SearchProductsController_productList", productList);
//		
//		carouselList = this.petStore.searchPopularList();
//		
//		map.put("productList", productList);
//		map.put("carouselList", carouselList);
//		
//		return new ModelAndView("SearchRestr", "productList", map);
	 System.out.println("test");
		return mav;
	}
}
