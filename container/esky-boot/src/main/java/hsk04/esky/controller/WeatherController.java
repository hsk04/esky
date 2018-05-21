package hsk04.esky.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hsk04.esky.constants.URI;
import hsk04.esky.entity.ECity;
import hsk04.esky.service.WeatherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = URI.WEATHER)
@CrossOrigin(origins="*")
public class WeatherController {

	private WeatherService service;

	public WeatherController(WeatherService service) {
		this.service = service;
	}

	// handle weather postings from mocker
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Create City Entity", notes = "Creates a City in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public ECity create(@RequestBody ECity ecity) {
		return service.create(ecity);
	}

	// Get the list of cities that have ever reported their weather in the past
	@RequestMapping(method = RequestMethod.GET, value = URI.CITIES)
	@ApiOperation(value = "Find All Cities", notes = "Returns a list of all cities in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<String> listOfCities() {
		return service.listOfCities();
	}

	// Get the latest weather for a given city
	@RequestMapping(method = RequestMethod.GET, value = URI.LATEST_CITY)
	@ApiOperation(value = "Find City Latest", notes = "Returns Latest City Forecast if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public ECity latestWeather(@PathVariable("city") String city) {
		return service.latestWeather(city);
	}

	// Get the latest weather property for a given city

	// specific attribute return

	@RequestMapping(method = RequestMethod.GET, value = URI.LATEST_DESCRIPTION)
	@ApiOperation(value = "Find City Latest Description", notes = "Returns Latest Description of a City if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public String latestDescription(@PathVariable("city") String city) {
		return service.latestDescription(city);
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.LATEST_HUMIDITY)
	@ApiOperation(value = "Find City Latest Humidity", notes = "Returns Latest Humidity of a City if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public float latestHumidity(@PathVariable("city") String city) {
		return service.latestHumidity(city);
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.LATEST_PRESSURE)
	@ApiOperation(value = "Find City Latest Pressure", notes = "Returns Latest Pressure of a City if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public float latestPressure(@PathVariable("city") String city) {
		return service.latestPressure(city);
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.LATEST_TEMPERATURE)
	@ApiOperation(value = "Find City Latest Temperature", notes = "Returns Latest Temperature of a City if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public float latestTemperature(@PathVariable("city") String city) {
		return service.latestTemperature(city);
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.LATEST_WINDSPEED)
	@ApiOperation(value = "Find City Latest WindSpeed", notes = "Returns Latest WindSpeed of a City if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public float latestWindSpeed(@PathVariable("city") String city) {
		return service.latestWindSpeed(city);
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.LATEST_WINDDEGREE)
	@ApiOperation(value = "Find City Latest WindDegree", notes = "Returns Latest WindDegree of a City if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public float latestWindDegree(@PathVariable("city") String city) {
		return service.latestWindDegree(city);
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.LATEST_TIMESTAMP)
	@ApiOperation(value = "Find City Latest TimeStamp", notes = "Returns Latest TimeStamp of a City if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public String latestTimeStamp(@PathVariable("city") String city) {
		return service.latestTimeStamp(city);
	}

	// specific attribute return

	// Get hourly averaged weather for a given city
	@RequestMapping(method = RequestMethod.GET, value = URI.HOURLY_CITY)
	@ApiOperation(value = "Find Hourly Average", notes = "Returns Hourly Average Forecast of a City if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public ECity hourlyAverage(@PathVariable("city") String city) {
		return service.hourlyAverage(city);
	}

	// Get daily averaged weather for a given city
	@RequestMapping(method = RequestMethod.GET, value = URI.DAILY_CITY)
	@ApiOperation(value = "Find Daily Average", notes = "Returns Daily Average Forecast of a City if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public ECity dailyAverage(@PathVariable("city") String city) {
		return service.dailyAverage(city);
	}
}
