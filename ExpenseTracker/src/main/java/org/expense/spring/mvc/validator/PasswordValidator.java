package org.expense.spring.mvc.validator;

import org.expense.application.util.MessageResouceBundleConstants;
import org.expense.spring.mvc.javabeans.LogonBean;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PasswordValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return LogonBean.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		LogonBean logonBean = (LogonBean) obj;
		if (!logonBean.getPassword().equals(logonBean.getPasswordDB())) {
			errors.rejectValue("errorMsg", MessageResouceBundleConstants.VALIDATION_LOGON_PASSWORD_NOT_MATCH);
		}
	}
}
