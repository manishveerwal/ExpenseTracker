package org.expense.spring.mvc.controller;

import javax.validation.Valid;

import org.expense.aplication.dao.UserDao;
import org.expense.spring.mvc.javabeans.LogonBean;
import org.expense.spring.mvc.validator.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogonController {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordValidator passwordValidator;
	
	@RequestMapping(value="/logon", method=RequestMethod.POST)
	public String logon(@Valid LogonBean logon, BindingResult result, Model model){
		if (result.hasErrors()) {
			return "index";
		}
		
		String passwordDB = userDao.getUserPassword(logon.getEmail());
		logon.setPasswordDB(passwordDB);
		passwordValidator.validate(logon, result);
		if (result.hasErrors()) {
			return "index";
		} else {
			return "dashboard";
		}
	}
	
	@RequestMapping(value="/logon", method=RequestMethod.GET)
	public String redirectToHomePage(){
		return "redirect:/home";
	}
}
