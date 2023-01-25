package workshop17.app.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import workshop17.app.model.Weather;

@Service
public class WeatherService {

  public Optional<Weather> getFromWeatherAPI(String city){
    final String OPEN_WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather";
    final String OPEN_WEATHER_API_KEY = System.getenv("OPEN_WEATHER_API_KEY");
    String weatherUrl = UriComponentsBuilder.fromUriString(OPEN_WEATHER_URL)
                        .queryParam("q", city.replaceAll(" ", "+"))
                        .queryParam("appid", OPEN_WEATHER_API_KEY)
                        .queryParam("units", "metric")
                        .toUriString();
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = null;
    response = restTemplate.getForEntity(weatherUrl, String.class);
    Weather w = Weather.create(response.getBody());
    if (w == null){
      return Optional.empty();
    }
    return Optional.of(w);
  }
}
