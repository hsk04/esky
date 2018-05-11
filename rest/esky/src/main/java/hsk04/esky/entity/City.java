package hsk04.esky.entity;

import java.text.SimpleDateFormat;

public class City {

	// private String id;
	//
	// public City() {
	// this.id = UUID.randomUUID().toString();
	// }

	private String cityName;
	private String description;
	private double humidity;
	private double pressure;
	private double temperature;
	private double windSpeed;
	private double windDegree;
	private SimpleDateFormat timeStamp;

	// public String getId() {
	// return id;
	// }
	//
	// public void setId(String id) {
	// this.id = id;
	// }

	public String getName() {
		return cityName;
	}

	public void setName(String cityName) {
		this.cityName = cityName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public double getWindDegree() {
		return windDegree;
	}

	public void setWindDegree(double windDegree) {
		this.windDegree = windDegree;
	}

	public SimpleDateFormat getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(SimpleDateFormat timeStamp) {
		this.timeStamp = timeStamp;
	}
}
