package hsk04.esky.service;

import java.util.List;

import hsk04.esky.entity.City;

public interface WeatherService {

	public City create(City city);

	public List<String> listOfCities();

	public City latestWeather(String cityName);

	public double latestTemperature(String cityName);

	public City hourlyAverage(String cityName);

	public City dailyAverage(String cityName);
}
