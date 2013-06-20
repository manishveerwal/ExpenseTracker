package org.expensetracker.test;

import org.expense.aplication.dao.MyJdbcDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {
	private static final String SPRING_XML = "/spring.xml";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(SPRING_XML);
		MyJdbcDao myJdbcDao = (MyJdbcDao) applicationContext.getBean("jdbcDao");
		System.out.println(myJdbcDao.getDataSource().toString());
	}
}
