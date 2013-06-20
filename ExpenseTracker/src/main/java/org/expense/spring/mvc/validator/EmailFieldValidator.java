package org.expense.spring.mvc.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EmailFieldValidator implements Validator {
	
	private Pattern pattern;
	
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	 
	public EmailFieldValidator(){
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return String.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		String email = (String) obj;
		Matcher matcher = pattern.matcher(email);
		if (!matcher.matches()) {
			errors.rejectValue("email", "", "Invalid Email Address.");
		}
	}
}
