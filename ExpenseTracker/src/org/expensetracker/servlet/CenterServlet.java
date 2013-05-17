package org.expensetracker.servlet;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.expensetracker.util.ApplicationUtil;

/**
 * Servlet implementation class CenterServlet
 */
@WebServlet(urlPatterns="/CenterServlet", loadOnStartup=1)
public class CenterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationUtil databaseUtil = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CenterServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
    	super.init();
    	databaseUtil = ApplicationUtil.getInstance();    	
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
