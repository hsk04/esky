package hsk04.esky.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hsk04.esky.entity.ECity;
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
	@Transactional
	public ECity create(ECity ecity) {
		return repository.create(ecity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<String> listOfCities() {
		return repository.listOfCities();
	}

	@Override
	@Transactional(readOnly = true)
	public ECity latestWeather(String city) {
		ECity existing = repository.latestWeather(city);
		if (existing == null) {
			throw new NotFoundException("Specified " + city + " " + "does not exist in the database");
		}
		return repository.latestWeather(city);
	}

	@Override
	@Transactional(readOnly = true)
	public double latestTemperature(String city) {
		ECity existing = repository.latestWeather(city);
		if (existing == null) {
			throw new NotFoundException("Specified " + city + " " + "does not exist in the database");
		}
		return repository.latestTemperature(city);
	}

	@Override
	@Transactional(readOnly = true)
	public ECity hourlyAverage(String city) {
		ECity existing = repository.hourlyAverage(city);
		if (existing == null) {
			throw new NotFoundException("Specified " + city + " " + "does not exist in the database");
		}
		return repository.hourlyAverage(city);
	}

	@Override
	@Transactional(readOnly = true)
	public ECity dailyAverage(String city) {
		ECity existing = repository.dailyAverage(city);
		if (existing == null) {
			throw new NotFoundException("Specified " + city + " " + "does not exist in the database");
		}
		return repository.dailyAverage(city);
	}

}
