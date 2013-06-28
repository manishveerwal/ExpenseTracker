package org.expense.spring.mvc.controller;

import org.expense.aplication.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExpenseAppController {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@RequestMapping("/category")
	public String openCategoryPage(Model model){
		model.addAttribute("categories", categoryDao.getCategories());
		return "category";
	}
}
