package com.adil.dao;

import java.io.IOException;

import com.adil.model.Weather;



public interface MockWeatherDAO {
	
	public void createFileAndSaveWeather(Weather weather) throws IOException;

}
