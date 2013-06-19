package org.expense.spring.mvc.validator;

import org.expense.spring.mvc.javabeans.RegistrationFormBean;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RegistrationFormBeanValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return RegistrationFormBean.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors error) {
		RegistrationFormBean registrationFormBean = (RegistrationFormBean) obj;
		
		if (!registrationFormBean.getPassword().equals(registrationFormBean.getPassword1())) {
			error.rejectValue("password", "", "Password and confirm Password does not match.");
		}
		
		if (registrationFormBean.getGender().equals("....")) {
			error.rejectValue("gender", "", "Please select your gender.");
		}
		
		if (registrationFormBean.getLocation().equals("....")) {
			error.rejectValue("location", "", "Please select your location.");
		}
	}
}
