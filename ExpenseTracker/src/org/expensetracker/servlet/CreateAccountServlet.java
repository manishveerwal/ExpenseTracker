package org.expensetracker.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.expensetracker.action.Action;
import org.expensetracker.action.CreateAccountAction;
import org.expensetracker.action.CreatePageDataAction;

/**
 * Servlet implementation class CreateAccountServlet
 */
@WebServlet("/CreateAccount")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccountServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}

	private void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Action action = null;
		if ("create".equals(request.getParameter("action"))) {
			action = new CreateAccountAction();
			action.execute(request, response);
			if (!response.isCommitted()) {
				request.getRequestDispatcher("login?page=home").forward(
						request, response);
			}
		} else {
			action = new CreatePageDataAction();
			action.execute(request, response);
			request.getRequestDispatcher("/WEB-INF/jsp/createAccount.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}
}
