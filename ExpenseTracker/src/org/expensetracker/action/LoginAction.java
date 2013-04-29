package org.expensetracker.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.expensetracker.util.DatabaseUtil;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class LoginAction implements Action {
	protected String GET_USER_DETAILS = "SELECT PASSWORD FROM USER_CREDENTIAL WHERE EMAIL=?";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {
			String forwardURL = null;
			String errorMsg = null;
			if ("".equals(email)) {
				errorMsg = "Email Field is empty.";
				forwardURL = "/WEB-INF/jsp/index.jsp";
			} else if ("".equals(password)) {
				errorMsg = "Password Field is empty.";
				forwardURL = "/WEB-INF/jsp/index.jsp";
			} else {
				SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(
						DatabaseUtil.getInstance().getDataSource());
				String passwordDB = simpleJdbcTemplate.queryForObject(
						GET_USER_DETAILS, String.class, email);

				if (passwordDB.equals(password)) {
					forwardURL = "html/home.html";
				} else {
					errorMsg = "Invalid Email or Password.";
					forwardURL = "/WEB-INF/jsp/index.jsp";
				}

			}
			if (errorMsg != null) {
				request.setAttribute("errorMessage", errorMsg);
			}
			request.getRequestDispatcher(forwardURL).forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
