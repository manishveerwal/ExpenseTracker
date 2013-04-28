package org.expensetracker.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.expensetracker.util.DatabaseUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class CreateAccountAction implements Action {
	protected String UPDATE_CREDENTIAL = "INSERT INTO USER_CREDENTIAL(email, password) VALUES(?, ?)";
	protected String UPDATE_DETAILS = "INSERT INTO USER_DETAILS(FIRSTNAME, LASTNAME, GENDER, LOCATION_ID, ID) VALUES(?, ?, ?, ?, ?)";
	protected String GET_USER_ID = "SELECT ID FROM USER_CREDENTIAL WHERE EMAIL=?";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String first = request.getParameter("firstName");
		String last = request.getParameter("lastName");
		String gender = request.getParameter("gender");
		String location = request.getParameter("location");
		
		try {
			SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(DatabaseUtil.getInstance().getDataSource());
			int rowUpdate = simpleJdbcTemplate.update(UPDATE_CREDENTIAL, email, password);
			if (rowUpdate > 0) {
				Integer id = simpleJdbcTemplate.queryForObject(GET_USER_ID, Integer.class, email);
				Integer location_id = simpleJdbcTemplate.queryForObject(CreatePageDataAction.GET_LOCATION_ID, Integer.class, location);
				simpleJdbcTemplate.update(UPDATE_DETAILS, first, last, gender, location_id, id);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/error.jsp?error=" + e.getMessage()).forward(request, response);
			} catch (ServletException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/error.jsp?error=" + e.getMessage()).forward(request, response);
			} catch (ServletException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
