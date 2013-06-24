package org.expense.spring.mvc.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.expense.spring.mvc.javabeans.LogonBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	@RequestMapping(value={"/", "/home"}, method=GET)
	public String showWelcomePage(Model model){
		//add LogonBean for modelAttribute
		model.addAttribute(new LogonBean());
		return "index";
	}
	
	@RequestMapping(value="/aboutus", method=GET)
	public String showAboutUsPage(){
		return "aboutus";
	}
}