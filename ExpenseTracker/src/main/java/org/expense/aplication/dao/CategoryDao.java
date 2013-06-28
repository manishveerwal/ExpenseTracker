package org.expense.aplication.dao;

import java.util.Iterator;
import java.util.List;

import org.expense.spring.mvc.javabeans.CategoryBean;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao extends ExpenseApplicationDao {
	
	public static final String GET_CATEGORY = "select CATEGORY_ID, CATEGORY_NAME from CATEGORY where " +
			"REF_CATEGORY_ID is null";
	
	public static final String GET_SUBCATEGORIES = "select CATEGORY_ID, CATEGORY_NAME from CATEGORY where " +
			"REF_CATEGORY_ID=?";
	
	public static final String INSERT_CATEGORY = "INSERT INTO CATEGORY(CATEGORY_NAME) VALUES(?)";
	
	public static final String GET_CATEGORY_ID = "select CATEGORY_ID from CATEGORY where CATEGORY_NAME=?";
	
	public static final String INSERT_SUB_CATEGORY = "INSERT INTO CATEGORY(CATEGORY_NAME, REF_CATEGORY_ID) VALUES(?, ?)";
	
	public static final String DELETE_SUB_CATEGORY = "DELETE FROM CATEGORY WHERE REF_CATEGORY_ID=?";
	
	public static final String DELETE_CATEGORY = "DELETE FROM CATEGORY WHERE CATEGORY_NAME=?";
	
	public static final String CHECK_REF = "select count(*) from category where category_name=? and " +
			"REF_CATEGORY_ID is null";
	
	public List<CategoryBean> getCategories(){
		List<CategoryBean> categoryBeans = getJdbcTemplate().query(GET_CATEGORY, new CategoryMapper());
		for (Iterator<CategoryBean> iterator = categoryBeans.iterator(); iterator.hasNext();) {
			CategoryBean categoryBean = iterator.next();
			categoryBean.setCategoryBeans(getJdbcTemplate().queryForList(GET_SUBCATEGORIES, 
					String.class, categoryBean.getCategoryId()));
		}
		return categoryBeans;
	}
	
	public Integer createCategory(String category){
		return getJdbcTemplate().update(INSERT_CATEGORY, category);
	}
	
	public Integer addSubCategory(String category, String subCategory){
		Integer categoryId = getJdbcTemplate().queryForObject(GET_CATEGORY_ID, Integer.class, category);
		return getJdbcTemplate().update(INSERT_SUB_CATEGORY, subCategory, categoryId);
	}
	
	public Integer deleteCategory(String category){
		Integer count = getJdbcTemplate().queryForObject(CHECK_REF, Integer.class, category);
		if (count > 0) {
			Integer categoryId = getJdbcTemplate().queryForObject(GET_CATEGORY_ID, Integer.class, category);
			getJdbcTemplate().update(DELETE_SUB_CATEGORY, categoryId);
		}
		return getJdbcTemplate().update(DELETE_CATEGORY, category);
	}

	
}
