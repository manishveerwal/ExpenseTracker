package org.expense.spring.mvc.controller;

import javax.validation.Valid;

import org.expense.spring.mvc.javabeans.LogonBean;
import org.expensetracker.dao.MyJdbcDao;
import org.expensetracker.util.ApplicationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogonController {
	protected String GET_USER_DETAILS = "SELECT PASSWORD FROM USER_CREDENTIAL WHERE EMAIL=?";
	
	@Autowired
	private MyJdbcDao jdbcDao;
	
	@RequestMapping(value="/logon", method=RequestMethod.POST)
	public String logon(@Valid LogonBean logon, BindingResult result, Model model){
		
		if (result.hasErrors()) {
			return "index";
		}
		
		JdbcTemplate jdbcTemplate = jdbcDao.getJdbcTemplate();
		String passwordDB = jdbcTemplate.queryForObject(
				GET_USER_DETAILS, String.class, logon.getEmail());
		
		if (passwordDB.equals(logon.getPassword())) {
			return "home";
		} else {
			model.addAttribute("errorMsg", "Invalid Email or Password.");
			return "redirect:index";
		}
	}
}
