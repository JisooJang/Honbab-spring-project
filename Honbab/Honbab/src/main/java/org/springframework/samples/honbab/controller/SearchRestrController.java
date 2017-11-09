package org.springframework.samples.honbab.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.samples.honbab.domain.Product;
import org.springframework.samples.honbab.service.PetStoreFacade;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchRestrController {
	
	private PetStoreFacade petStore;

	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	@RequestMapping("/shop/searchProducts.do")
	public ModelAndView handleRequest(HttpServletRequest request,
			@RequestParam(value="keyword", required=false) String keyword,
			@RequestParam(value="page", required=false) String page
			) throws Exception {
		
		Map map = new HashMap();
		List<Product> carouselList;
		List<Product> productList;
		if (keyword != null) {
			productList = new ArrayList<Product>(this.petStore.searchProductList(keyword.toLowerCase()));
		}
		else {
			productList = new ArrayList<Product>(this.petStore.searchProductList(""));
		}
		
		request.getSession().setAttribute("SearchProductsController_productList", productList);
		
		carouselList = this.petStore.searchPopularList();
		
		map.put("productList", productList);
		map.put("carouselList", carouselList);
		
		return new ModelAndView("SearchRestr", "productList", map);
	}
	
	@RequestMapping(value="/shop/searchProducts2.do")
	public ModelAndView handleRequest(HttpServletRequest request,
			@RequestParam(value="restrctg", required=false) Integer restrctg,
			@RequestParam(value="area", required=false) Integer area,
			@RequestParam(value="page", required=false) String page
			) throws Exception {
		Map map = new HashMap();
		List<Product> productList;
		List<Product> carouselList;
		String keyword = "";
		if (restrctg != null) {
			productList = new ArrayList<Product>(this.petStore.getProductListByCategory(keyword.toLowerCase(), area, restrctg));
		}
		else {
			productList = new ArrayList<Product>(this.petStore.searchProductList(""));
		}
		
		request.getSession().setAttribute("SearchProductsController_productList", productList);
		
		// 罹먮윭���쓣 �쐞�븳 由ъ뒪�듃 (異붿쿇 紐⑸줉)
		
		carouselList = this.petStore.searchPopularList();
		//湲곗〈 由ъ뒪�듃 
		map.put("productList", productList);
		map.put("carouselList", carouselList);
		
		return new ModelAndView("SearchRestr", "productList", map);
	}
}
