package org.expense.aplication.dao;

import java.util.List;

import org.expense.spring.mvc.javabeans.Location;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class LocationDao extends ExpenseApplicationDao {

	protected String GET_LOCATIONS = "SELECT LOCATION FROM LOCATION";
	
	protected String GET_LOCATION_ID = "SELECT LOCATION_ID FROM LOCATION WHERE LOCATION=?";
	
	public List<Location> getLocations(){
		return getJdbcTemplate().query(GET_LOCATIONS, ParameterizedBeanPropertyRowMapper.newInstance(Location.class));
	}
	
	public Integer getLocationID(String location){
		return getJdbcTemplate().queryForObject(GET_LOCATION_ID, Integer.class, location);
	}
}
