package com.regis.sandbox.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.regis.sandbox.model.Admin;
import com.regis.sandbox.service.AdminManager;



@Component("admin")
public class AdminValidator {
	
	private AdminManager adminManager;
	
	@Autowired
	public void setPatientManager(AdminManager adminManager) {
		this.adminManager = adminManager;
	}
	
	
	public void validateAdmin(Admin admin, Errors errors) {
		if(admin.getfirstName().trim().equals("")){
			errors.rejectValue("firstName", "firstName","First name tidak boleh kosong");
		} 
		
		if(admin.getlastName().trim().equals("")){
			errors.rejectValue("lastName", "lastName","Last name tidak boleh kosong");
		} 
		
		if(admin.getPhoneNumber().trim().equals("")){
			errors.rejectValue("phoneNumber","phoneNumber","Phone Number tidak boleh kosong");
		} else {
			Admin userValidation = adminManager.getByPhoneNumber(admin.getPhoneNumber());
			if(userValidation != null ) {
				errors.rejectValue("phoneNumber","phoneNumber","Phone Number telah terdaftar");
			}
		}
		
		if(admin.getEmail().trim().equals("")){
			errors.rejectValue("email","email","Email tidak boleh kosong");
		} else {
			Admin userValidation = adminManager.getByEmail(admin.getEmail());
			if(userValidation != null ) {
				errors.rejectValue("email","email","Email telah terdaftar");
			}
		}
		
		if (admin.getPassword().trim().equals("")) {
			errors.rejectValue("password","password","Please fill Password");
		}
		
	}
}
	
	
	
	
