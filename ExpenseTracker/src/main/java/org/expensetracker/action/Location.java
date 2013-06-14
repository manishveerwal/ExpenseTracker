package org.expensetracker.action;

public class Location {
	private String location;
	public Location() {
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return location;
	}
}
