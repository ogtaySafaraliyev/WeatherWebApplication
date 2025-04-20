package com.example.weather_app.model;

import java.util.List;

public class WeatherResponse {

	private String name;

	private Sys sys;

	private List<Weather> weather;

	private Main main;

	private Wind wind;

	// nested class 
	public static class Sys {

		private String country;

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}
	}
	
	// nested class  
	public static class Weather {

		private int id;

		private String description;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

	}
	
	// nested class  
	public static class Main {

		private double temp;

		private int humidity;
		

		public int getHumidity() {
			return humidity;
		}

		public void setHumidity(int humidity) {
			this.humidity = humidity;
		}

		public double getTemp() {
			return temp;
		}

		public void setTemp(double temp) {
			this.temp = temp;
		}

	}
	
	// nested class  
	public static class Wind {
		
		private double speed;

		public double getSpeed() {
			return speed;
		}

		public void setSpeed(double speed) {
			this.speed = speed;
		}
	}
	
	// getter and setters of fields in WeatherResponse class
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sys getSys() {
		return sys;
	}

	public void setSys(Sys sys) {
		this.sys = sys;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

}
