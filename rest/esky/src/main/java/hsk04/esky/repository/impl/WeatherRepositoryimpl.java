package hsk04.esky.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import hsk04.esky.entity.ECity;
import hsk04.esky.repository.WeatherRepository;

@Repository
public class WeatherRepositoryimpl implements WeatherRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public ECity create(ECity city) {
		em.persist(city);
		return city;
	}

	@Override
	public List<String> listOfCities() {
		ArrayList<String> cityList = new ArrayList<String>();
		String city1 = "Fort Collins";
		String city2 = "Denver";
		String city3 = "Colorado Springs";
		cityList.add(city1);
		cityList.add(city2);
		cityList.add(city3);
		return cityList;
	}

	@Override
	public ECity latestWeather(String city) {
		ECity ecity = new ECity();
		ecity.setName("Fort Collins");
		ecity.setTemperature(60);
		ecity.setDescription("sunny");
		ecity.setHumidity(50);
		return ecity;
	}

	@Override
	public double latestTemperature(String city) {
		return 0;
	}

	@Override
	public ECity hourlyAverage(String city) {
		return null;
	}

	@Override
	public ECity dailyAverage(String city) {
		return null;
	}

}
