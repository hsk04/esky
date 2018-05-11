package hsk04.esky.repository;

import java.util.List;

import hsk04.esky.entity.City;

public interface WeatherRepository {

	public City create(City city);

	public List<String> listOfCities();

	public City latestWeather(String cityName);

	public double latestTemperature(String cityName);

	public City hourlyAverage(String cityName);

	public City dailyAverage(String cityName);
}
