package hsk04.esky.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wind {

	@Id
	private String id;

	public Wind() {
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private float speed;
	private float degree;

	// Getter Methods

	public float getSpeed() {
		return speed;
	}

	public float getDegree() {
		return degree;
	}

	// Setter Methods

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public void setDegree(float degree) {
		this.degree = degree;
	}
}