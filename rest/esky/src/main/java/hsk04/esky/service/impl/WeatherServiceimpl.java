package hsk04.esky.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import hsk04.esky.entity.City;
import hsk04.esky.exception.NotFoundException;
import hsk04.esky.repository.WeatherRepository;
import hsk04.esky.service.WeatherService;

@Service
public class WeatherServiceimpl implements WeatherService {

	private WeatherRepository repository;

	public WeatherServiceimpl(WeatherRepository repository) {
		this.repository = repository;
	}

	@Override
	public City create(City city) {
		return repository.create(city);
	}

	@Override
	public List<String> listOfCities() {
		return repository.listOfCities();
	}

	@Override
	public City latestWeather(String cityName) {
		City existing = repository.latestWeather(cityName);
		if (existing == null) {
			throw new NotFoundException("Specified " + cityName + " " + "does not exist in the database");
		}
		return repository.latestWeather(cityName);
	}

	@Override
	public double latestTemperature(String cityName) {
		City existing = repository.latestWeather(cityName);
		if (existing == null) {
			throw new NotFoundException("Specified " + cityName + " " + "does not exist in the database");
		}
		return repository.latestTemperature(cityName);
	}

	@Override
	public City hourlyAverage(String cityName) {
		City existing = repository.hourlyAverage(cityName);
		if (existing == null) {
			throw new NotFoundException("Specified " + cityName + " " + "does not exist in the database");
		}
		return repository.hourlyAverage(cityName);
	}

	@Override
	public City dailyAverage(String cityName) {
		City existing = repository.dailyAverage(cityName);
		if (existing == null) {
			throw new NotFoundException("Specified " + cityName + " " + "does not exist in the database");
		}
		return repository.dailyAverage(cityName);
	}

}
