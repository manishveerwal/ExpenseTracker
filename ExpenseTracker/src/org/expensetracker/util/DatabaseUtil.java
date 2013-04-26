package org.expensetracker.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseUtil {
	private static final String JDBC_EXPENSE_APP = "jdbc/ExpenseApp";
	private DataSource ds = null;
	private static DatabaseUtil databaseUtil = new DatabaseUtil();
	
	private DatabaseUtil() {
		try {
			Context context = new InitialContext();
			Context envContext = (Context) context.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup(JDBC_EXPENSE_APP);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static DatabaseUtil getInstance() {
		return databaseUtil;
	}
	
	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	public DataSource getDataSource() {
		return ds;
	}
}
