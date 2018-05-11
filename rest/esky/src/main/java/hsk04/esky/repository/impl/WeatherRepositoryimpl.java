package hsk04.esky.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import hsk04.esky.entity.City;
import hsk04.esky.repository.WeatherRepository;

@Repository
public class WeatherRepositoryimpl implements WeatherRepository {

	@Override
	public City create(City city) {
		city.setName("Fort Collins");
		city.setTemperature(60);
		city.setDescription("sunny");
		city.setHumidity(50);
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
	public City latestWeather(String cityName) {
		City city = new City();
		city.setName("Fort Collins");
		city.setTemperature(60);
		city.setDescription("sunny");
		city.setHumidity(50);
		return city;
	}

	@Override
	public double latestTemperature(String cityName) {
		return 0;
	}

	@Override
	public City hourlyAverage(String cityName) {
		return null;
	}

	@Override
	public City dailyAverage(String cityName) {
		return null;
	}

}
