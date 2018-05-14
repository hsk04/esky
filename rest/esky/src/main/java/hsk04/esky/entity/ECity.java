package hsk04.esky.entity;

import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ECity {

	@Id
	private String id;
	private String city;
	private String description;
	private double humidity;
	private double pressure;
	private double temperature;
	private double windspeed;
	private double winddegree;
	private SimpleDateFormat timestamp;

	public ECity() {
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return city;
	}

	public void setName(String city) {
		this.city = city;
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
		return windspeed;
	}

	public void setWindSpeed(double windspeed) {
		this.windspeed = windspeed;
	}

	public double getWindDegree() {
		return winddegree;
	}

	public void setWindDegree(double winddegree) {
		this.winddegree = winddegree;
	}

	public SimpleDateFormat getTimeStamp() {
		return timestamp;
	}

	public void setTimeStamp(SimpleDateFormat timestamp) {
		this.timestamp = timestamp;
	}
}
