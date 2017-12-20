package com.adil.dao.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.stereotype.Repository;

import com.adil.dao.MockWeatherDAO;
import com.adil.model.Weather;





@Repository
public class MockWeatherDAOImpl implements MockWeatherDAO {

	public void createFileAndSaveWeather(Weather weather)  throws IOException {
		String seperator = System.lineSeparator();
		String weatherOutputData = "State: " + weather.getState() + seperator + "City: " + weather.getCity() + seperator
				+ "High: " + weather.getHigh() + seperator + "Low: " + weather.getLow();

		FileOutputStream fileOutput = new FileOutputStream("/Users/Ram/Desktop/data/"
				+ weather.getCity() + LocalDate.now() +"weather.txt");

		fileOutput.write(weatherOutputData.getBytes());
		fileOutput.close();

	}

	public void saveIntoDB(Weather weather) throws SQLException, ClassNotFoundException {
		// create a mysql database connection
		String myDriver = "com.mysql.jdbc.Driver";
		String myUrl = "jdbc:mysql://localhost/playingfield";
		Class.forName(myDriver);
		Connection conn = DriverManager.getConnection(myUrl, "root", "pass");

		// the mysql insert statement
		String query = " insert into weather_data (city, state, high, low)" + " values (?, ?, ?, ?)";

		// create the mysql insert preparedstatement
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.setString(1, weather.getCity());
		preparedStmt.setString(2, weather.getState());
		preparedStmt.setInt(3, weather.getHigh());
		preparedStmt.setInt(4, weather.getLow());

		// execute the preparedstatement
		preparedStmt.execute();

		conn.close();

	}
}
