package org.expense.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController {
	
	@RequestMapping(value="/dashboard")
	public String openDashboard(){
		return "dashboard";
	}
	
	@RequestMapping("/expense")
	public String openExpenses(){
		return "expenses";
	}
	
	@RequestMapping("/addExpense")
	public String openAddExpense(){
		return "addExpense";
	}
}
