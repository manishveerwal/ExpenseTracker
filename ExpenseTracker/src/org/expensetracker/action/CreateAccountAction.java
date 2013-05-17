package org.expensetracker.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.expensetracker.util.ApplicationUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class CreateAccountAction implements Action {
	protected String UPDATE_CREDENTIAL = "INSERT INTO USER_CREDENTIAL(email, password) VALUES(?, ?)";
	protected String UPDATE_DETAILS = "INSERT INTO USER_DETAILS(FIRSTNAME, LASTNAME, GENDER, LOCATION_ID, ID) VALUES(?, ?, ?, ?, ?)";
	protected String GET_USER_ID = "SELECT ID FROM USER_CREDENTIAL WHERE EMAIL=?";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String password1 = request.getParameter("password1");
		String first = request.getParameter("firstName");
		String last = request.getParameter("lastName");
		String gender = request.getParameter("gender");
		String location = request.getParameter("location");

		if (!password.equals(password1)) {
			try {
				request.setAttribute("errorMessage",
						"Password does not MATCH!!!");
				request.getRequestDispatcher("CreateAccount").forward(request,
						response);
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			}
			return;
		}

		JdbcTemplate jdbcTemplate = ApplicationUtil.getInstance().getMyJdbcDao().getJdbcTemplate();
		int rowUpdate = jdbcTemplate.update(UPDATE_CREDENTIAL, email,
				password);
		if (rowUpdate > 0) {
			Integer id = jdbcTemplate.queryForObject(GET_USER_ID,
					Integer.class, email);
			Integer location_id = jdbcTemplate.queryForObject(
					CreatePageDataAction.GET_LOCATION_ID, Integer.class,
					location);
			jdbcTemplate.update(UPDATE_DETAILS, first, last, gender,
					location_id, id);
		}
	}
}
