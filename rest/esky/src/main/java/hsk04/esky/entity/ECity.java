package hsk04.esky.entity;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({ @NamedQuery(name = "ECity.getLatestCity", query = "SELECT e FROM ECity e where e.city=:pCity"),
		@NamedQuery(name = "ECity.getUniqueCity", query = "SELECT DISTINCT(e.city) FROM ECity e"), })
public class ECity {

	@Id
	private String id;

	public ECity() {
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String city;
	private String description;
	private float humidity;
	private float pressure;
	private float temperature;
	@OneToOne(cascade = CascadeType.ALL)
	Wind WindObject;
	private String timestamp;

	// Getter Methods

	public String getCity() {
		return city;
	}

	public String getDescription() {
		return description;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}

	public float getTemperature() {
		return temperature;
	}

	public Wind getWind() {
		return WindObject;
	}

	public String getTimestamp() {
		return timestamp;
	}

	// Setter Methods

	public void setCity(String city) {
		this.city = city;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public void setWind(Wind windObject) {
		this.WindObject = windObject;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}