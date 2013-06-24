package org.expense.aplication.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends ExpenseApplicationDao {
	
	protected static final String GET_USER_DETAILS = "SELECT PASSWORD FROM USER_CREDENTIAL WHERE EMAIL=?";
	
	public String getUserPassword(String email){
		return getJdbcTemplate().queryForObject(
				GET_USER_DETAILS, String.class, email);
	}
}
