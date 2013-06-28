package org.expense.aplication.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.expense.spring.mvc.javabeans.CategoryBean;
import org.springframework.jdbc.core.RowMapper;

public class CategoryMapper implements RowMapper<CategoryBean> {
	public static final String CATEGORY_ID = "CATEGORY_ID";
	
	public static final String CATEGORY_NAME = "CATEGORY_NAME";
	
	public static final String REF_CATEGORY_ID = "REF_CATEGORY_ID";
	
	@Override
	public CategoryBean mapRow(ResultSet resultSet, int arg1) throws SQLException {
		return new CategoryBean(resultSet.getInt(CATEGORY_ID), resultSet.getString(CATEGORY_NAME));
	}
}
