package com.adil.ui;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.adil.model.Weather;
import com.adil.service.WeatherService;


@ComponentScan(basePackages = "com.adil")
public class WeatherApp {
	
	 public static void main(String[] args) throws IOException {

	        ApplicationContext context
	                = new AnnotationConfigApplicationContext(WeatherApp.class);

	        WeatherApp p = context.getBean(WeatherApp.class);
	        p.start();
	    }
	 
	 	@Autowired
	    WeatherService weatherService;
	    private void start() throws IOException {
	    	System.out.println("Please enter the city: ");
			String city = new Scanner(System.in).nextLine();

			System.out.println("Please enter the state: ");
			String state = new Scanner(System.in).nextLine();

			System.out.println("Please enter the high: ");
			int high = new Scanner(System.in).nextInt();

			System.out.println("Please enter the low: ");
			int low = new Scanner(System.in).nextInt();

			Weather weather = new Weather(high, low, city, state);
			
			System.out.println(weatherService.saveWeather(weather));
	    }

	
}
