package hsk04.esky.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hsk04.esky.entity.City;

@RestController
@RequestMapping(value = "/weather")
public class WeatherController {

	@RequestMapping(method = RequestMethod.POST)
	public City create(@RequestBody City city) {
		return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/cities")
	public List<String> listOfCities() {
		return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/temperature/{cityName}")
	public City latestWeather(@PathVariable("cityName") String cityName) {
		return null;
	}

	// specific attribute return

	@RequestMapping(method = RequestMethod.GET, value = "/{cityName}")
	public double latestTemperature(@PathVariable("cityName") String cityName) {
		return 2.5;
	}

	// specific attribute return

	@RequestMapping(method = RequestMethod.GET, value = "/{cityName}")
	public City hourlyAverage(@PathVariable("cityName") String cityName) {
		return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{cityName}")
	public City dailyAverage(@PathVariable("cityName") String cityName) {
		return null;
	}
}
