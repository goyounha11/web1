package com.kwon.db.weather;

public class Weather {
	private String hour;
	private String temp;
	private String weather;
	private String img;

	public Weather() {
		// TODO Auto-generated constructor stub
	}

	public Weather(String hour, String temp, String weather, String img) {
		super();
		this.hour = hour;
		this.temp = temp;
		this.weather = weather;
		this.img = img;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
