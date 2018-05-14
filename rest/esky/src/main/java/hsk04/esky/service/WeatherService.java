package hsk04.esky.service;

import java.util.List;

import hsk04.esky.entity.ECity;

public interface WeatherService {

	public ECity create(ECity city);

	public List<String> listOfCities();

	public ECity latestWeather(String city);

	public double latestTemperature(String city);

	public ECity hourlyAverage(String city);

	public ECity dailyAverage(String city);
}
