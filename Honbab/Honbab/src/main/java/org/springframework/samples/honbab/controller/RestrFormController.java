package org.springframework.samples.honbab.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.samples.honbab.domain.Menu;
import org.springframework.samples.honbab.service.PetStoreFacade;
import org.springframework.samples.honbab.service.RestrFormValidator;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

@Controller
@RequestMapping({"/shop/newRestr.do"})
public class RestrFormController {
	
	@Value("tiles/Test")
	private String formViewName;
	
	@Value("tiles/Test")
	private String successViewName;
	
	private static final String[] Categories = {"한식", "일식", "중식", "양식"};
	
	@Autowired
	private PetStoreFacade petStore;
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	@ModelAttribute("restrForm")
	public RestrForm restrFormBackingObject(HttpServletRequest request) 
			throws Exception {
		
		UserSession userSession = 
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		System.out.println(userSession.getAccount().getRest_id() );
		try{
			
			if (userSession.getAccount().getRest_id() != 0) {	// edit an existing account
				System.out.println("restrform1");
				return new RestrForm(petStore.getRestr(userSession.getAccount().getRest_id()),
						petStore.getMenuList(userSession.getAccount().getRest_id()));
				
				
			}
			else {	
				// create a new account
				return new RestrForm();
			
			}
		}catch(Exception e){
			return new RestrForm();
		}
		
	}
	
		
	@Autowired
	private RestrFormValidator validator;
	public void setValidator(RestrFormValidator validator) {
		this.validator = validator;
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		
		return "tiles/Test";
	}
	
	/*@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception {
		
	}*/
	@Transactional
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(
			HttpServletRequest request, HttpSession session,
			MultipartHttpServletRequest multipartReq,
			@ModelAttribute("restrForm") RestrForm restrForm,
			BindingResult result) throws Exception {
		
		System.out.println("restrForm submit");
		validator.validate(restrForm, result);
		System.out.println(restrForm.getMenuList().get(0).getMenu_name());
		
		if (result.hasErrors()) return formViewName;
		try {
			UserSession userSession = 
			(UserSession) WebUtils.getSessionAttribute(request, "userSession");
			
			//restrForm.getRestr().setUser_id(userSession.getAccount().getUser_id());
			restrForm.getRestr().setRest_reser_count(0);
			MultipartFile thunmbnail = multipartReq.getFile("thumbnail");
			
			
			if (restrForm.isNewRestr()) {
				System.out.println("restrForm insert");
				petStore.insertRestr(restrForm.getRestr());
				petStore.updateRestIDOfAccount(restrForm.getRestr().getRest_id(), userSession.getAccount().getUser_id());
				if (thunmbnail != null) {
					
					String root_path = request.getSession().getServletContext().getRealPath("/");  
					String attach_path = "images\\restr\\";
//		            String path = "C:/menu/";
					String fileName = Integer.toString(restrForm.getRestr().getRest_id());

		            try {
		 
		                File file = new File(root_path + attach_path + fileName + ".jpg");
		                System.out.println(root_path + attach_path + fileName + ".jpg");
//		            	File file = new File(path + fileName + ".jpg"); 
		                thunmbnail.transferTo(file);
		                restrForm.getRestr().setRest_thumbnail("../images/restr/"+fileName+".jpg");
		            	petStore.updateImageOfRestr(restrForm.getRestr());
		                
		            } catch (IOException e) {
		                e.printStackTrace();
		            } 
		        } 
				
				int i = 0;
				for(Menu menu: restrForm.getMenuList()){
					menu.setRest_id(restrForm.getRestr().getRest_id());
					petStore.insertMenu(menu);
					
					MultipartFile menuImage = restrForm.getMenufiles().get(i);
					
					
					if (menuImage != null) {
						System.out.println(menuImage);
						String root_path = request.getSession().getServletContext().getRealPath("/");  
						String attach_path = "images\\menu\\";
			            String path = "C:/menu/";
						String fileName = Integer.toString(menu.getMenu_id());
	
			            try {
			 
			                File file = new File(root_path + attach_path + fileName + ".jpg");
			                System.out.println(root_path + attach_path + fileName + ".jpg");
//			            	File file = new File(path + fileName + ".jpg"); 
			            	menuImage.transferTo(file);
			            	menu.setMenu_image("../images/menu/"+fileName+".jpg");
			            	petStore.insertImageOfMenu(menu);
			                
			            } catch (IOException e) {
			                e.printStackTrace();
			            } 
			        } 


					i++;
				}
				
			}
			else {
				
				if (thunmbnail != null) {
					
					String root_path = request.getSession().getServletContext().getRealPath("/");  
					String attach_path = "images\\restr\\";
//		            String path = "C:/menu/";
					String fileName = Integer.toString(restrForm.getRestr().getRest_id());

		            try {
		 
		                File file = new File(root_path + attach_path + fileName + ".jpg");
		                System.out.println(root_path + attach_path + fileName + ".jpg");
//		            	File file = new File(path + fileName + ".jpg"); 
		                thunmbnail.transferTo(file);
		                restrForm.getRestr().setRest_thumbnail("../images/restr/"+fileName+".jpg");
		            	petStore.updateImageOfRestr(restrForm.getRestr());
		                
		            } catch (IOException e) {
		                e.printStackTrace();
		            } 
		        } 
	
				petStore.updateRestr(restrForm.getRestr());
				
			
				int i = 0;
				for(Menu menu: restrForm.getMenuList()){
					
					menu.setRest_id(restrForm.getRestr().getRest_id());
					petStore.updateMenu(menu);
					
					if(restrForm.getMenufiles() != null){
					MultipartFile menuImage = restrForm.getMenufiles().get(i);
					
					
					if (menuImage != null) {
						System.out.println(menuImage);
						String root_path = request.getSession().getServletContext().getRealPath("/");  
						String attach_path = "images\\menu\\";
			            String path = "C:/menu/";
						String fileName = Integer.toString(menu.getMenu_id());
	
			            try {
			 
			                File file = new File(root_path + attach_path + fileName + ".jpg");
			                
			               System.out.println(root_path + attach_path + fileName + ".jpg");
//			            	File file = new File(path + fileName + ".jpg"); 
			            	menuImage.transferTo(file);
			            	menu.setMenu_image("../images/menu/"+fileName+".jpg");
			            	petStore.insertImageOfMenu(menu);
			                
			            } catch (IOException e) {
			                e.printStackTrace();
			            } 
			        } 
					}

					i++;
				}
			
			}
		}
		catch (DataIntegrityViolationException ex) {
			ex.printStackTrace();
			result.rejectValue("restr.rest_id", "RESTR_ID_ALREADY_EXISTS",
					"Restr ID already exists: choose a different ID.");
			return formViewName; 
		}
		
		
		return successViewName; 
	}

}
