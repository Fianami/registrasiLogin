package com.regis.sandbox.controller;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.regis.sandbox.model.Admin;
import com.regis.sandbox.service.AdminManager;
import com.regis.sandbox.validator.AdminValidator;

@Controller
@RequestMapping("admin")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	private AdminManager adminManager;
	private Validator validator;
	private AdminValidator adminValidator;

	
	@Autowired
	public void setAdminValidator(AdminValidator adminValidator) {
		this.adminValidator = adminValidator;
	}

	@Autowired
	public void setAdminManager(AdminManager adminManager) {
		this.adminManager = adminManager;
	}

	@Autowired
	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@RequestMapping("")
	public String list(Model model) {
		model.addAttribute("admin", adminManager.getAll());
		return "admin/list";
	}

	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addNew(Model model) {
		model.addAttribute("admin", new Admin());
		return "admin/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String save(@ModelAttribute("admin") Admin admin, BindingResult errors, HttpServletRequest request) {
		/*
		 * if(doctor.getName().length()>5){ errors.rejectValue("name",
		 * "doctor.name", "Error"); }
		 */
		HttpSession httpSession = request.getSession();
		adminValidator.validateAdmin(admin, errors);
		if (errors.hasErrors()) {
			httpSession.setAttribute("errors", errors);
			return "admin/add";
		}
//		if (validator != null) {
//			validator.validate(admin, errors);
//		}
		if (errors.hasErrors()) {
			return "admin/add";
		}
		admin.setPassword(sha256(admin.getPassword()));
	
		this.adminManager.save(admin);

		return "redirect:/admin";
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
	
	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) {
		NumberFormat numberFormat = NumberFormat.getNumberInstance(request
				.getLocale());
		numberFormat.setMinimumFractionDigits(2);
		numberFormat.setMaximumFractionDigits(2);

		binder.registerCustomEditor(BigDecimal.class, new CustomNumberEditor(
				BigDecimal.class, numberFormat, true));
		binder.registerCustomEditor(Integer.class, null,
				new CustomNumberEditor(Integer.class, null, true));
		binder.registerCustomEditor(Long.class, null, new CustomNumberEditor(
				Long.class, null, true));
		binder.registerCustomEditor(byte[].class,
				new ByteArrayMultipartFileEditor());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, null, new CustomDateEditor(
				dateFormat, true));
	}

}
