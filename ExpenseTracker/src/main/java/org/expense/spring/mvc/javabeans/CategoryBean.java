package org.expense.spring.mvc.javabeans;

import java.util.List;

public class CategoryBean {
	
	private Integer categoryId;
	private String categoryName;
	private List<String> categoryBeans;
	
	public CategoryBean() {
	}

	public CategoryBean(Integer categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}



	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public List<String> getCategoryBeans() {
		return categoryBeans;
	}

	public void setCategoryBeans(List<String> categoryBeans) {
		this.categoryBeans = categoryBeans;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
