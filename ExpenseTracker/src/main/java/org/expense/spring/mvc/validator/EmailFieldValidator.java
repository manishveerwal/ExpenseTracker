package org.expense.spring.mvc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EmailFieldValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return String.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		String email = (String) obj;
	}
}
