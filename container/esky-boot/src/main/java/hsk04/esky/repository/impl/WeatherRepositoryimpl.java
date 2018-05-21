package hsk04.esky.repository.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import hsk04.esky.entity.ECity;
import hsk04.esky.entity.Wind;
import hsk04.esky.repository.WeatherRepository;

@Repository
public class WeatherRepositoryimpl implements WeatherRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public ECity create(ECity ecity) {
		em.persist(ecity);
		return ecity;
	}

	// @SuppressWarnings("unchecked")
	@Override
	public List<String> listOfCities() {
		TypedQuery<String> query = em.createNamedQuery("ECity.getUniqueCity", String.class);
		return query.getResultList();
	}

	@Override
	public ECity latestWeather(String city) {
		TypedQuery<ECity> query = em.createNamedQuery("ECity.getLatestCity", ECity.class);
		query.setParameter("pCity", city);
		List<ECity> cities = query.getResultList();
		if (!cities.isEmpty()) {
			return cities.get(cities.size() - 1);
		} else {
			return null;
		}
	}

	@Override
	public String latestDescription(String city) {
		TypedQuery<ECity> query = em.createNamedQuery("ECity.getLatestCity", ECity.class);
		query.setParameter("pCity", city);
		List<ECity> cities = query.getResultList();
		if (!cities.isEmpty()) {
			return cities.get(cities.size() - 1).getDescription();
		} else {
			return " ";
		}
	}

	@Override
	public float latestHumidity(String city) {
		TypedQuery<ECity> query = em.createNamedQuery("ECity.getLatestCity", ECity.class);
		query.setParameter("pCity", city);
		List<ECity> cities = query.getResultList();
		if (!cities.isEmpty()) {
			return cities.get(cities.size() - 1).getHumidity();
		} else {
			return -1;
		}
	}

	@Override
	public float latestPressure(String city) {
		TypedQuery<ECity> query = em.createNamedQuery("ECity.getLatestCity", ECity.class);
		query.setParameter("pCity", city);
		List<ECity> cities = query.getResultList();
		if (!cities.isEmpty()) {
			return cities.get(cities.size() - 1).getPressure();
		} else {
			return -1;
		}
	}

	@Override
	public float latestTemperature(String city) {
		TypedQuery<ECity> query = em.createNamedQuery("ECity.getLatestCity", ECity.class);
		query.setParameter("pCity", city);
		List<ECity> cities = query.getResultList();
		if (!cities.isEmpty()) {
			return cities.get(cities.size() - 1).getTemperature();
		} else {
			return -1;
		}
	}

	@Override
	public float latestWindSpeed(String city) {
		TypedQuery<ECity> query = em.createNamedQuery("ECity.getLatestCity", ECity.class);
		query.setParameter("pCity", city);
		List<ECity> cities = query.getResultList();
		if (!cities.isEmpty()) {
			return cities.get(cities.size() - 1).getWind().getSpeed();
		} else {
			return -1;
		}
	}

	@Override
	public float latestWindDegree(String city) {
		TypedQuery<ECity> query = em.createNamedQuery("ECity.getLatestCity", ECity.class);
		query.setParameter("pCity", city);
		List<ECity> cities = query.getResultList();
		if (!cities.isEmpty()) {
			return cities.get(cities.size() - 1).getWind().getDegree();
		} else {
			return -1;
		}
	}

	@Override
	public String latestTimeStamp(String city) {
		TypedQuery<ECity> query = em.createNamedQuery("ECity.getLatestCity", ECity.class);
		query.setParameter("pCity", city);
		List<ECity> cities = query.getResultList();
		if (!cities.isEmpty()) {
			return cities.get(cities.size() - 1).getTimestamp();
		} else {
			return " ";
		}
	}

	@Override
	public ECity hourlyAverage(String city) {
		TypedQuery<ECity> query = em.createNamedQuery("ECity.getLatestCity", ECity.class);
		query.setParameter("pCity", city);
		List<ECity> cities = query.getResultList();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		Date d1 = new Date();

		int count = 0;
		float humidity = 0;
		float pressure = 0;
		float temperature = 0;
		float windspeed = 0;
		float winddegreee = 0;

		if (!cities.isEmpty()) {
			for (ECity temp : cities) {
				try {
					Date d2 = sdf.parse(temp.getTimestamp());
					if (d1.getTime() - d2.getTime() < 3600000) {
						count++;
						humidity = humidity + temp.getHumidity();
						pressure = pressure + temp.getPressure();
						temperature = temperature + temp.getTemperature();
						windspeed = windspeed + temp.getWind().getSpeed();
						winddegreee = winddegreee + temp.getWind().getDegree();
					}

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (count == 0) {
				return null;
			} else {
				ECity avg = new ECity();
				Wind windObject = new Wind();
				avg.setCity(city);
				avg.setDescription("Not Applicable");
				avg.setTimestamp("Not Applicable");
				avg.setWind(windObject);
				avg.setHumidity(humidity / count);
				avg.setPressure(pressure / count);
				avg.setTemperature(temperature / count);
				windObject.setSpeed(windspeed / count);
				windObject.setDegree(winddegreee / count);
				return avg;
			}
		} else {
			return null;
		}
	}

	@Override
	public ECity dailyAverage(String city) {
		TypedQuery<ECity> query = em.createNamedQuery("ECity.getLatestCity", ECity.class);
		query.setParameter("pCity", city);
		List<ECity> cities = query.getResultList();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		Date d1 = new Date();

		int count = 0;
		float humidity = 0;
		float pressure = 0;
		float temperature = 0;
		float windspeed = 0;
		float winddegreee = 0;

		if (!cities.isEmpty()) {
			for (ECity temp : cities) {
				try {
					Date d2 = sdf.parse(temp.getTimestamp());
					if (d1.getTime() - d2.getTime() < 86400000) {
						count++;
						humidity = humidity + temp.getHumidity();
						pressure = pressure + temp.getPressure();
						temperature = temperature + temp.getTemperature();
						windspeed = windspeed + temp.getWind().getSpeed();
						winddegreee = winddegreee + temp.getWind().getDegree();
					}

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (count == 0) {
				return null;
			} else {
				ECity avg = new ECity();
				Wind windObject = new Wind();
				avg.setDescription("Not Applicable");
				avg.setTimestamp("Not Applicable");
				avg.setWind(windObject);
				avg.setHumidity(humidity / count);
				avg.setPressure(pressure / count);
				avg.setTemperature(temperature / count);
				windObject.setSpeed(windspeed / count);
				windObject.setDegree(winddegreee / count);
				return avg;
			}
		} else {
			return null;
		}
	}

}
