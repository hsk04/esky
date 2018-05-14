package hsk04.esky.repository;

import java.util.List;

import hsk04.esky.entity.ECity;

public interface WeatherRepository {

	public ECity create(ECity city);

	public List<String> listOfCities();

	public ECity latestWeather(String city);

	public double latestTemperature(String city);

	public ECity hourlyAverage(String city);

	public ECity dailyAverage(String city);
}
