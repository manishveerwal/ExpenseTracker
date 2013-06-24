package org.expense.aplication.dao;

import org.expense.spring.mvc.javabeans.RegistrationFormBean;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends ExpenseApplicationDao {
	
	protected static final String GET_USER_DETAILS = "SELECT PASSWORD FROM USER_CREDENTIAL WHERE EMAIL=?";
	
	protected static final String INSERT_CREDENTIAL = "INSERT INTO USER_CREDENTIAL(email, password) VALUES(?, ?)";
	
	protected static final String INSERT_DETAILS = "INSERT INTO USER_DETAILS(FIRSTNAME, " +
			"LASTNAME, GENDER, LOCATION_ID, ID) VALUES(?, ?, ?, ?, ?)";
	
	protected static final String GET_USER_ID = "SELECT ID FROM USER_CREDENTIAL WHERE EMAIL=?";
	
	protected static final String CHECK_EMAIL = "SELECT COUNT(*) FROM USER_CREDENTIAL WHERE EMAIL=?";
	
	public String getUserPassword(String email){
		return getJdbcTemplate().queryForObject(
				GET_USER_DETAILS, String.class, email);
	}
	
	public Integer insertCredentials(String email, String password){
		return getJdbcTemplate().update(INSERT_CREDENTIAL, email, password);
	}
	
	public Integer getUserID(String email){
		return getJdbcTemplate().queryForObject(GET_USER_ID,
				Integer.class, email);
	}
	
	public void insertUserDetails(RegistrationFormBean registrationFormBean, Integer location_id, Integer id){
		getJdbcTemplate().update(INSERT_DETAILS, registrationFormBean.getFirstName(), registrationFormBean.getLastName(),
				registrationFormBean.getGender(),
				location_id, id);
	}
	
	public Integer checkEmailAvailability(String email){
		return getJdbcTemplate().queryForObject(CHECK_EMAIL,
				Integer.class, email);
	}
}
