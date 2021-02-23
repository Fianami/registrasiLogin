package com.regis.sandbox.controller;

import java.security.MessageDigest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.regis.sandbox.model.Admin;
import com.regis.sandbox.service.AdminManager;

@Controller
@RequestMapping("login")
public class LoginController {

	private AdminManager adminManager;

	@Autowired
	public void setAdminManager(AdminManager adminManager) {
		this.adminManager = adminManager;
	}
	
	/*@RequestMapping(value="", method=RequestMethod.GET)
	 public ModelAndView errorLogin(@RequestParam(value="error", required=false) String error){
	  System.out.println("masuk login , error : " + error);
	  ModelAndView modelAndView = new ModelAndView();
	  if (error != null) {
	   modelAndView.addObject("error", "USER NOT FOUND!");
	  }
	  modelAndView.setViewName("login");
	  return modelAndView;
	 }*/

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String login(Model model,HttpServletRequest request) {
		model.addAttribute("admin", this.adminManager.getAll());
		HttpSession httpSession = request.getSession();
		httpSession.removeValue("errors");
		return "/login";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String Autentichate(@RequestParam("username") String name,
			@RequestParam("password") String password, HttpServletRequest request,
			Model model) {
		System.out.println("masuk login , nama : " + name);
		String Error ="";
		HttpSession httpSession = request.getSession();
		if (password == null || password.isEmpty()) {
			Error = "Null Password";
		}
		if (name == null || name.isEmpty()) {
			Error = "Null Name";
		}
		
		Admin admin = this.adminManager.getByName(name);
		
		if(admin == null){
			Error = "user not found";
			
		}
		if (Error.equals("")) {
			if (sha256(password).equals(admin.getPassword())) {
				
				httpSession.setAttribute("username", name);
				return "redirect:/hello";	
				
			} else 
				{
				Error = "Wrong Password";
				}
		}
		httpSession.setAttribute("errors", Error);
		return "/login";

	}
	
	public static String sha256(String base) {
	    try{
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = digest.digest(base.getBytes("UTF-8"));
	        StringBuffer hexString = new StringBuffer();

	        for (int i = 0; i < hash.length; i++) {
	            String hex = Integer.toHexString(0xff & hash[i]);
	            if(hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }

	        return hexString.toString();
	    } catch(Exception ex){
	       throw new RuntimeException(ex);
	    }
	}
	/*@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String Autentichate(@RequestParam("name") String name,
			@RequestParam("psw") String password, HttpServletRequest request,
			Model model) {
		if (password == null || password.isEmpty()) {
			model.addAttribute("errors", "Null Password");
			return "error";
		}
		if (name == null || name.isEmpty()) {
			model.addAttribute("errors", "Null Name");
			return "error";
		}
		
		Customer customer = this.customerManager.getByName(name);
		
		if(customer == null){
			model.addAttribute("errors", "user not found ");
			return "error";
		}
		if (password.equals(customer.getPassword())) {
			
				if(customer.getUserRole().equals("admin")){
					HttpSession httpSession = request.getSession();
					httpSession.setAttribute("adminSession", customer);
					return "redirect:/home_admin";	
				}
				if(customer.getUserRole().equals("customer")){
					HttpSession httpSession = request.getSession();
					httpSession.setAttribute("sessionUser", customer);
					httpSession.setAttribute("sessionIdTrainSchedule", null);
					httpSession.setAttribute("sessionIdCarriage", null);
					httpSession.setAttribute("detailCarriageScheduleSession", new DetailCarriageSchedule());
					httpSession.setAttribute("sessionTransaction", new Transaction());
					httpSession.setAttribute("detailCarriageScheduleSession", new DetailCarriageSchedule());
					//httpSession.setAttribute("selectedSeatListSession", new ArrayList<Seat>());
					httpSession.setAttribute("selectedTransactionSession", new ArrayList<DetailTransaction>());
					httpSession.setAttribute("newDetailTransactionSession", new ArrayList<DetailTransaction>());
				
					return "redirect:/home_customer";
				}
			
		} else 
			{
			model.addAttribute("errors", "Wrong Password ");
			return "error";
			}
		
		return "error";
	}*/

}
