package com.regis.sandbox.controller;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletRequest;
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

@Controller
@RequestMapping("hello")
public class HelloController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	private AdminManager adminManager;
	private Validator validator;

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
		return "hello/list";
	}


}
