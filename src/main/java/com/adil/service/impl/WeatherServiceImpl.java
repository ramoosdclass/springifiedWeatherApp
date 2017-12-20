package com.adil.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adil.dao.MockWeatherDAO;
import com.adil.model.Weather;
import com.adil.service.WeatherService;



@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	MockWeatherDAO mockDAO;
	
	public String saveWeather(Weather weather) throws IOException {

		

		if (weather.getHigh() > 180 && weather.getLow() < -30) {
			return "The weather cannot be greater than 180 or less than -30";
		}

		if (weather.getState().isEmpty()) {
			return "jdsjsk";
		}

		else {

			try {
				mockDAO.createFileAndSaveWeather(weather);
			} finally {
				System.out.println("I am finally block: I get executed whether" + "I catch an exception or not");
			}

			// mockDAO.saveIntoDB(weather);
		}

		return "The Weather has beerrn successfully saved in folder";
	}
}
