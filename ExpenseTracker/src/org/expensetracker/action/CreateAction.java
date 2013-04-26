package org.expensetracker.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.expensetracker.util.DatabaseUtil;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class CreateAction implements Action {
	String query = "select location from location";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(DatabaseUtil.getInstance().getDataSource());
		List<Location> locations = simpleJdbcTemplate.query(query, ParameterizedBeanPropertyRowMapper.newInstance(Location.class));
		request.setAttribute("locations", locations);
	}
}
