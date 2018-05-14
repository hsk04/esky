package hsk04.esky.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hsk04.esky.constants.URI;
import hsk04.esky.entity.ECity;
import hsk04.esky.service.WeatherService;

@RestController
@RequestMapping(value = URI.WEATHER)
public class WeatherController {

	private WeatherService service;

	public WeatherController(WeatherService service) {
		this.service = service;
	}

	// handle weather postings from mocker
	@RequestMapping(method = RequestMethod.POST)
	public ECity create(@RequestBody ECity ecity) {
		return service.create(ecity);
	}

	// Get the list of cities that have ever reported their weather in the past
	@RequestMapping(method = RequestMethod.GET, value = URI.CITIES)
	public List<String> listOfCities() {
		return service.listOfCities();
	}

	// Get the latest weather for a given city
	@RequestMapping(method = RequestMethod.GET, value = URI.LATEST_CITY)
	public ECity latestWeather(@PathVariable("city") String city) {
		return service.latestWeather(city);
	}

	// Get the latest weather property for a given city
	// specific attribute return

	@RequestMapping(method = RequestMethod.GET, value = URI.LATEST_TEMPERATURE)
	public double latestTemperature(@PathVariable("city") String city) {
		return service.latestTemperature(city);
	}

	// specific attribute return

	// Get hourly averaged weather for a given city
	@RequestMapping(method = RequestMethod.GET, value = URI.HOURLY_CITY)
	public ECity hourlyAverage(@PathVariable("city") String city) {
		return service.hourlyAverage(city);
	}

	// Get daily averaged weather for a given city
	@RequestMapping(method = RequestMethod.GET, value = URI.DAILY_CITY)
	public ECity dailyAverage(@PathVariable("city") String city) {
		return service.dailyAverage(city);
	}
}
