package com.adil.service;

import java.io.IOException;

import com.adil.model.Weather;





public interface WeatherService  {
	
	public String saveWeather(Weather weather) throws IOException;

}
