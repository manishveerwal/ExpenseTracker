package org.expensetracker.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.expensetracker.dao.MyJdbcDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationUtil {
	private static final String SPRING_XML = "/spring.xml";
	public static final String JAVA_COMP_ENV = "java:/comp/env";
	public static final String JDBC_EXPENSE_APP = "jdbc/ExpenseApp";
	private DataSource ds = null;
	private static ApplicationUtil applicationUtil = new ApplicationUtil();
	private MyJdbcDao myJdbcDao = null;
	
	private ApplicationUtil() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(SPRING_XML);
		this.myJdbcDao = (MyJdbcDao) applicationContext.getBean("jdbcDao");
	}
	
	public static ApplicationUtil getInstance() {
		return applicationUtil;
	}
	
	public Connection getConnection() throws SQLException {
		return myJdbcDao.getDataSource().getConnection();
	}

	public DataSource getDataSource() {
		return myJdbcDao.getDataSource();
	}

	public MyJdbcDao getMyJdbcDao() {
		return myJdbcDao;
	}
}
