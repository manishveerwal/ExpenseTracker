package org.expense.spring.mvc.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.expense.aplication.dao.MyJdbcDao;
import org.expense.spring.mvc.javabeans.Location;
import org.expense.spring.mvc.javabeans.RegistrationFormBean;
import org.expense.spring.mvc.model.EmailValidationJSON;
import org.expense.spring.mvc.validator.EmailFieldValidator;
import org.expense.spring.mvc.validator.RegistrationFormBeanValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterationController {
	
	protected String INSERT_CREDENTIAL = "INSERT INTO USER_CREDENTIAL(email, password) VALUES(?, ?)";
	protected String UPDATE_DETAILS = "INSERT INTO USER_DETAILS(FIRSTNAME, LASTNAME, GENDER, LOCATION_ID, ID) VALUES(?, ?, ?, ?, ?)";
	protected String GET_USER_ID = "SELECT ID FROM USER_CREDENTIAL WHERE EMAIL=?";
	protected String CHECK_EMAIL = "SELECT COUNT(*) FROM USER_CREDENTIAL WHERE EMAIL=?";
	
	protected String GET_LOCATIONS = "SELECT LOCATION FROM LOCATION";
	protected String GET_LOCATION_ID = "SELECT LOCATION_ID FROM LOCATION WHERE LOCATION=?";

	@Autowired
	private MyJdbcDao jdbcDao;
	
	@Autowired
	private RegistrationFormBeanValidator registrationFormBeanValidator;
	
	@Autowired
	private EmailFieldValidator emailFieldValidator;
	
	@Autowired
	private ResourceBundleMessageSource messageSource;
	
	@RequestMapping("/register")
	public String openRegistrationPage(Model model){
		model.addAttribute("locations", getLocation());
		model.addAttribute(new RegistrationFormBean());
		return "createAccount";
	}

	public List<Location> getLocation() {
		JdbcTemplate jdbcTemplate = jdbcDao.getJdbcTemplate();
		List<Location> locations = jdbcTemplate.query(GET_LOCATIONS, ParameterizedBeanPropertyRowMapper.newInstance(Location.class));
		return locations;
	}
	
	@RequestMapping(value="/processRegistration", method=RequestMethod.POST)
	public String processRegistration(@Valid RegistrationFormBean registrationFormBean, BindingResult result
			, Model model){
		registrationFormBeanValidator.validate(registrationFormBean, result);

		if (result.hasErrors()) {
			model.addAttribute("locations", getLocation());
			return "createAccount";
		}
		
		insertUserDetails(registrationFormBean);
		return "redirect:/home";
	}

	private void insertUserDetails(RegistrationFormBean registrationFormBean) {
		JdbcTemplate jdbcTemplate = jdbcDao.getJdbcTemplate();
		int rowUpdate = jdbcTemplate.update(INSERT_CREDENTIAL, registrationFormBean.getEmail(),
				registrationFormBean.getPassword());
		if (rowUpdate > 0) {
			Integer id = jdbcTemplate.queryForObject(GET_USER_ID,
					Integer.class, registrationFormBean.getEmail());
			Integer location_id = jdbcTemplate.queryForObject(
					GET_LOCATION_ID, Integer.class,
					registrationFormBean.getLocation());
			jdbcTemplate.update(UPDATE_DETAILS, registrationFormBean.getFirstName(), registrationFormBean.getLastName(),
					registrationFormBean.getGender(),
					location_id, id);
		}
	}
	
	@RequestMapping(value={"/processRegistration"}, method=RequestMethod.GET)
	public String redirectToRegistrationPage(){
		return "redirect:/register";
	}
	
	@RequestMapping(value="/checkEmailAvailability", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody EmailValidationJSON checkEmailAvailability(@RequestParam String email){
		RegistrationFormBean registrationFormBean = new RegistrationFormBean();
		registrationFormBean.setEmail(email);
		
		Errors errors = new BindException(registrationFormBean, "email");
		emailFieldValidator.validate(email, errors);
		if (errors.hasErrors()) {
			return new EmailValidationJSON(false, getErrorMessage(errors.getFieldError("email").getCode()));
		}
		
		JdbcTemplate jdbcTemplate = jdbcDao.getJdbcTemplate();
		Integer count = jdbcTemplate.queryForObject(CHECK_EMAIL,
				Integer.class, email);
		if (count > 0) {
			return new EmailValidationJSON(false, getErrorMessage("validation.email.registered"));
		} else {
			return new EmailValidationJSON(true, "");
		}
	}

	private String getErrorMessage(String code) {
		return messageSource.getMessage(code, 
				null, Locale.ROOT);
	}
}
