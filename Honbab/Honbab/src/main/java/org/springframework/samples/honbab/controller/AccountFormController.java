package org.springframework.samples.honbab.controller;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.samples.honbab.service.AccountFormValidator;
import org.springframework.samples.honbab.service.PetStoreFacade;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;


@Controller
@RequestMapping({"/shop/newAccount.do","/shop/editAccount.do"})
public class AccountFormController { 

	@Value("tiles/EditAccountForm")
	private String formViewName;
	@Value("index")
	private String successViewName;
	private static final String[] LANGUAGES = {"english", "japanese"};
	private static final String[] Types = {"normal", "owner"};
	private static final String[] Genders = {"female", "male"};
	
	@Autowired
	private PetStoreFacade petStore;
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}

	@Autowired
	private AccountFormValidator validator;
	public void setValidator(AccountFormValidator validator) {
		this.validator = validator;
	}
		
	@ModelAttribute("accountForm")
	public AccountForm formBackingObject(HttpServletRequest request) 
			throws Exception {
		UserSession userSession = 
			(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		if (userSession != null) {	// edit an existing account
			return new AccountForm(
				petStore.getAccount(userSession.getAccount().getUser_id()));
		}
		else {	
			// create a new account
			return new AccountForm();
		}
	}

	@ModelAttribute("languages")
	public String[] getLanguages() {
		return LANGUAGES;
	}
	
	@ModelAttribute("types")
	public String[] getTypes() {
		return Types;
	}

	@ModelAttribute("genders")
	public String[] getGenders() {
		return Genders;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(
			HttpServletRequest request, HttpSession session,
			 MultipartHttpServletRequest multipartReq,
			@ModelAttribute("accountForm") AccountForm accountForm,
			BindingResult result) throws Exception {

		/*if (request.getParameter("account.listOption") == null) {
			accountForm.getAccount().setListOption(false);
		}
		if (request.getParameter("account.bannerOption") == null) {
			accountForm.getAccount().setBannerOption(false);
		}*/
		/*
		if (request.getParameter("account.user_id") == null) {
			
			System.out.println("user_id is null");
			accountForm.getAccount().setUser_id("user");
		}*/
		
		//validator.validate(accountForm, result);
		
		//if (result.hasErrors()) return formViewName;
		try {
			
		
			if (accountForm.isNewAccount()) {
				System.out.println(accountForm.getAccount().getProfile());
				accountForm.getAccount().setProfile("");
				petStore.insertAccount(accountForm.getAccount());
				System.out.println("insert2");
				
				MultipartFile profile = multipartReq.getFile("profile");
				System.out.println(profile.getOriginalFilename());
				if (profile != null) {
					System.out.println("profile");
					String root_path = request.getSession().getServletContext().getRealPath("/");  
					String attach_path = "images\\account\\";
//		            String path = "C:/menu/";
					String fileName = accountForm.getAccount().getUser_id();

		            try {
		 
		                File file = new File(root_path + attach_path + fileName + ".jpg");
		               /* System.out.println(root_path + attach_path + fileName + ".jpg");*/
//		            	File file = new File(path + fileName + ".jpg"); 
		                System.out.println(root_path + attach_path + fileName + ".jpg");
		                profile.transferTo(file);
		                accountForm.getAccount().setProfile("../images/account/"+fileName+".jpg");
		            	petStore.updateImageOfAccount(accountForm.getAccount());
		            	System.out.println("updateImage");
		            } catch (IOException e) {
		                e.printStackTrace();
		            } 
		        } 
			}
			else {
				MultipartFile profile = multipartReq.getFile("profile");
				System.out.println(profile.getOriginalFilename());
				if (profile != null) {
					System.out.println("profile");
					String root_path = request.getSession().getServletContext().getRealPath("/");  
					String attach_path = "images\\account\\";
//		            String path = "C:/menu/";
					String fileName = accountForm.getAccount().getUser_id();

		            try {
		 
		                File file = new File(root_path + attach_path + fileName + ".jpg");
		               /* System.out.println(root_path + attach_path + fileName + ".jpg");*/
//		            	File file = new File(path + fileName + ".jpg"); 
		                System.out.println(root_path + attach_path + fileName + ".jpg");
		                profile.transferTo(file);
		                accountForm.getAccount().setProfile("../images/account/"+fileName+".jpg");
		            	petStore.updateImageOfAccount(accountForm.getAccount());
		            
		            } catch (IOException e) {
		                e.printStackTrace();
		            } 
		        }
				petStore.updateAccount(accountForm.getAccount());
				
				
			}
			
			
		}
		catch (DataIntegrityViolationException ex) {
			ex.printStackTrace();
			result.rejectValue("account.username", "USER_ID_ALREADY_EXISTS",
					"User ID already exists: choose a different ID.");
			return formViewName; 
		}
		
		UserSession userSession = new UserSession(
			petStore.getAccount(accountForm.getAccount().getUser_id()));
		System.out.println("name: " + accountForm.getAccount().getUser_id());
		/*PagedListHolder<Product> myList = new PagedListHolder<Product>(
			petStore.getProductListByCategory(accountForm.getAccount().getFavouriteCategoryId()));
		myList.setPageSize(4);
		userSession.setMyList(myList);*/
		session.setAttribute("userSession", userSession);
		return successViewName;  
	}
}
