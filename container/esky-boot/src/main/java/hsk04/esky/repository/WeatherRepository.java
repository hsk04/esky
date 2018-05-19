package hsk04.esky.repository;

import java.util.List;

import hsk04.esky.entity.ECity;

public interface WeatherRepository {

	public ECity create(ECity city);

	public List<String> listOfCities();

	public ECity latestWeather(String city);

	public String latestDescription(String city);

	public float latestHumidity(String city);

	public float latestPressure(String city);

	public float latestTemperature(String city);

	public float latestWindSpeed(String city);

	public float latestWindDegree(String city);

	public String latestTimeStamp(String city);

	public ECity hourlyAverage(String city);

	public ECity dailyAverage(String city);

}
