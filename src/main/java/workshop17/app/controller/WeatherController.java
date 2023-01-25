package workshop17.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import workshop17.app.model.Weather;
import workshop17.app.service.WeatherService;

@Controller

public class WeatherController {

  @Autowired
  WeatherService wSvc;
  
  @GetMapping("/weather")
  public String getWeather(@RequestParam(value = "q", required = true) String q, Model model){
    // Call WeatherService
    Weather weather = wSvc.getFromWeatherAPI(q).get();
    model.addAttribute("weather", weather);
    return "weather";
  }
}
