package org.expense.spring.mvc.javabeans;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class LogonBean {
	
	@NotEmpty
	@Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message="Invalid email address")
	private String email;
	
	@NotEmpty
	private String password;
	
	private String passwordDB;
	
	private String errorMsg;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordDB() {
		return passwordDB;
	}

	public void setPasswordDB(String passwordDB) {
		this.passwordDB = passwordDB;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
