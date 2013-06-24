package org.expense.aplication.dao;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public abstract class ExpenseApplicationDao extends JdbcDaoSupport {
	
	@Autowired
	private DataSource dataSource;
	
	public ExpenseApplicationDao(){
	}
	
	@PostConstruct
	public void setDataSource(){
		setDataSource(dataSource);
	}
}
