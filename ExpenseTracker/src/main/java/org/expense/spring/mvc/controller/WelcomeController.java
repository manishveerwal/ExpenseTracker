package org.expense.spring.mvc.controller;

import org.apache.log4j.Logger;
import org.expense.spring.mvc.javabeans.LogonBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class WelcomeController {
	
	private static final Logger log = Logger.getLogger(WelcomeController.class);
	
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