package org.springframework.samples.honbab.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.samples.honbab.domain.Menu;
import org.springframework.samples.honbab.domain.Product;
import org.springframework.samples.honbab.domain.Review;
import org.springframework.samples.honbab.service.OrderService;
import org.springframework.samples.honbab.service.PetStoreFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

@Controller
public class RestrDetailController {
	
	private PetStoreFacade petStore;
	private OrderService orderService;
	private String restrStarString; //null처리를 위해 String형
	private int restrStar;
	private int reviewStar;
	private int newStar;
	private int count;
	
	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	@Autowired
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	//1
	@ModelAttribute("reviewCommand")
	public ReviewCommand formBacking(HttpServletRequest request) throws Exception {
		
		ReviewCommand review = new ReviewCommand();
		
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
			if (userSession != null) {	// edit an existing account
				review.getReview().setUser_id(userSession.getAccount().getUser_id());
			}
			else {	
				review.getReview().setUser_id("비회원");
			}
			
			return review;
	}
	
	
	//2
	//해당 restr정보와 댓글 보여주기 
	@RequestMapping("/restrDetail.do/{rest_id}")
	public ModelAndView handleRequest(HttpServletRequest request, @PathVariable int rest_id) throws Exception {
		
			count = this.petStore.countReview(rest_id);
			System.out.println(count);
			ModelAndView mav = new ModelAndView("RestrDetail");
			
			Product pickedRestr = new Product();
			pickedRestr = this.petStore.getRestr(rest_id);
			mav.addObject("restr", pickedRestr);
			
			List<Menu> menuList = new ArrayList<Menu>(this.orderService.getMenuByRestr(rest_id));
			request.getSession().setAttribute("RestrDetailController_menuList", menuList);
			mav.addObject("menuList", menuList);
		
	         
			List<Review> reviewList = new ArrayList<Review>(this.petStore.searchReviewList(rest_id));
			request.getSession().setAttribute("RestrDetailController_reviewList", reviewList);
			mav.addObject("reviewList", reviewList);
			
			return mav;
	}
	
	//3
	//addReview처리
	@RequestMapping(value="/addReview.do", method=RequestMethod.POST)
	public ModelAndView reviewSubmit(
			HttpServletRequest request,
			@ModelAttribute("reviewCommand") ReviewCommand review) throws Exception {		
		
		ModelAndView mav = new ModelAndView("RestrDetail");
		
		int rest_id = review.getReview().getRest_id();
		
		Product pickedRestr = new Product();
		pickedRestr = this.petStore.getRestr(rest_id);
		
		//별점 변경
		restrStarString = this.petStore.getTotalReviewStar(rest_id);
		System.out.println("restrStarString : " + restrStarString);
		if(restrStarString == null)
			restrStar = 0;
		else  restrStar = Integer.parseInt(restrStarString);

		System.out.println("restrStar : " + restrStar);
		
		reviewStar = review.getReview().getReview_star();
		newStar = restrStar + reviewStar;
		System.out.println("newStar1 : " + newStar);
		count++;
		newStar = newStar / count;
		
		if(newStar >= 5)
			newStar = 5;
		System.out.println("newStar2 : " + newStar);
		
		int rest_star = newStar;
		
		this.petStore.updateStar(rest_star, rest_id);
		
		
		//다시 받아오기
		pickedRestr = this.petStore.getRestr(rest_id);
		mav.addObject("restr", pickedRestr);
		
		List<Menu> menuList = new ArrayList<Menu>(this.orderService.getMenuByRestr(rest_id));
		request.getSession().setAttribute("RestrDetailController_menuList", menuList);
		mav.addObject("menuList", menuList);
		
		Review newreview = new Review();
		newreview.setReview_content(review.getReview().getReview_content());
		newreview.setRest_id(rest_id);
		newreview.setReview_star(review.getReview().getReview_star());
		newreview.setUser_id(review.getReview().getUser_id());
		this.petStore.insertReview(newreview);
		
		List<Review> reviewList = new ArrayList<Review>(this.petStore.searchReviewList(rest_id));
		request.getSession().setAttribute("RestrDetailController_reviewList", reviewList);
		mav.addObject("reviewList", reviewList);
		
		return mav;
		
	}
	
	//deletReview처리
		@RequestMapping(value="/deleteReview.do/{review_id}/{rest_id}")
		public ModelAndView reviewSubmit2(HttpServletRequest request, @PathVariable int review_id, @PathVariable int rest_id) throws Exception {
			ModelAndView mav = new ModelAndView("RestrDetail");
			
			Product pickedRestr = new Product();
			pickedRestr = this.petStore.getRestr(rest_id);
			
			//별점 변경
			restrStarString = this.petStore.getTotalReviewStar(rest_id);
			if(restrStarString == null)
				restrStar = 0;
			else  restrStar = Integer.parseInt(restrStarString);
			
			System.out.println("restrStar : " + restrStar);
			
			reviewStar = this.petStore.getReviewStar(review_id);
			newStar = restrStar - reviewStar;
			System.out.println("newStar1 : " + newStar);
			count--;
			if(count == 0)
				newStar = 0;
			else
				newStar = newStar / count;
			
			if(newStar >= 5)
				newStar = 5;
			System.out.println("newStar2 : " + newStar);
			int rest_star = newStar;
			
			this.petStore.updateStar(rest_star, rest_id);
			System.out.println("ye4");
			
			//다시 받아오기
			pickedRestr = this.petStore.getRestr(rest_id);
			mav.addObject("restr", pickedRestr);
			
			List<Menu> menuList = new ArrayList<Menu>(this.orderService.getMenuByRestr(rest_id));
			request.getSession().setAttribute("RestrDetailController_menuList", menuList);
			mav.addObject("menuList", menuList);
			
			this.petStore.deleteReview(review_id);
		
			List<Review> reviewList = new ArrayList<Review>(this.petStore.searchReviewList(rest_id));
			request.getSession().setAttribute("RestrDetailController_reviewList", reviewList);
			mav.addObject("reviewList", reviewList);
			
			return mav;
		}
	
}
