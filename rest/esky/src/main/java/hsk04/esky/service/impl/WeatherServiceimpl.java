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
		return existing;
	}

	@Override
	@Transactional(readOnly = true)
	public String latestDescription(String city) {
		String existing = repository.latestDescription(city);
		if (existing == " ") {
			throw new NotFoundException("Specified " + city + " " + "does not exist in the database");
		}
		return existing;
	}

	@Override
	@Transactional(readOnly = true)
	public float latestHumidity(String city) {
		float existing = repository.latestHumidity(city);
		if (existing < 0) {
			throw new NotFoundException("Specified " + city + " " + "does not exist in the database");
		}
		return existing;
	}

	@Override
	@Transactional(readOnly = true)
	public float latestPressure(String city) {
		float existing = repository.latestPressure(city);
		if (existing < 0) {
			throw new NotFoundException("Specified " + city + " " + "does not exist in the database");
		}
		return existing;
	}

	@Override
	@Transactional(readOnly = true)
	public float latestTemperature(String city) {
		float existing = repository.latestTemperature(city);
		if (existing < 0) {
			throw new NotFoundException("Specified " + city + " " + "does not exist in the database");
		}
		return existing;
	}

	@Override
	@Transactional(readOnly = true)
	public float latestWindSpeed(String city) {
		float existing = repository.latestWindSpeed(city);
		if (existing < 0) {
			throw new NotFoundException("Specified " + city + " " + "does not exist in the database");
		}
		return existing;
	}

	@Override
	@Transactional(readOnly = true)
	public float latestWindDegree(String city) {
		float existing = repository.latestWindDegree(city);
		if (existing < 0) {
			throw new NotFoundException("Specified " + city + " " + "does not exist in the database");
		}
		return existing;
	}

	@Override
	@Transactional(readOnly = true)
	public String latestTimeStamp(String city) {
		String existing = repository.latestTimeStamp(city);
		if (existing == " ") {
			throw new NotFoundException("Specified " + city + " " + "does not exist in the database");
		}
		return existing;
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
