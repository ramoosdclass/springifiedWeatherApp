package com.adil.model;

public class Weather {

	private int high;
	private int low;
	private String city;
	private String state;

	// default
	public Weather() {

	}

	// parameterized constructor with all weather properties
	public Weather(int high, int low, String city, String state) {
		this.high = high;
		this.low = low;
		this.city = city;
		this.state = state;

	}

	// parameterized constructor with just city and state properties
	// constructor can be overloaded too
	public Weather(String city, String state) {
		this.city = city;
		this.state = state;

	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
