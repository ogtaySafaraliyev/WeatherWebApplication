package com.example.weather_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;

import com.example.weather_app.model.WeatherResponse;

//import lombok.Value;

@Controller
public class WeatherController {

	@Value("${api.key}")
	private String apiKey;

	@GetMapping("/abc")
	public String getIndex() {
		return "index";
	}

	@GetMapping("/weather")
	public String getWeather(@RequestParam("city") String city, Model model) {

		try {
			String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appId=" + apiKey
					+ "&units=metric";
			RestTemplate restTemplate = new RestTemplate();
			WeatherResponse weatherResponse = restTemplate.getForObject(url, WeatherResponse.class);

			if (weatherResponse != null) {
				model.addAttribute("city", weatherResponse.getName());
				model.addAttribute("country", weatherResponse.getSys().getCountry());
				model.addAttribute("weatherDescription", weatherResponse.getWeather().get(0).getDescription());
				model.addAttribute("temperature", weatherResponse.getMain().getTemp());
//				System.out.println(weatherResponse.getMain().getTemp());
				model.addAttribute("humidity", weatherResponse.getMain().getHumidity());
				model.addAttribute("windSpeed", weatherResponse.getWind().getSpeed());

				String weatherIcon = "wi wi-owm-" + weatherResponse.getWeather().get(0).getId();
				model.addAttribute("weatherIcon", weatherIcon);
			} else {
				model.addAttribute("error", "City not found");
			}

		}

		catch (HttpClientErrorException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				model.addAttribute("error", "City not found: " + city);
			} else {
				model.addAttribute("error", "Error fetching weather data");
			}
		} catch (Exception e) {
			model.addAttribute("error", "Unexpected error occurred");
		}
		return "weather";
	}

}
