package org.expensetracker.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.expensetracker.util.ApplicationUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class CreatePageDataAction implements Action {
	protected String query = "SELECT LOCATION FROM LOCATION";
	protected static String GET_LOCATION_ID = "SELECT LOCATION_ID FROM LOCATION WHERE LOCATION=?";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		JdbcTemplate jdbcTemplate = ApplicationUtil.getInstance().getMyJdbcDao().getJdbcTemplate();
		List<Location> locations = jdbcTemplate.query(query, ParameterizedBeanPropertyRowMapper.newInstance(Location.class));
		request.setAttribute("locations", locations);
	}
}
