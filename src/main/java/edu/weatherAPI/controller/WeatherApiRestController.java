package edu.weatherAPI.controller;

import edu.weatherAPI.model.Weather;
import edu.weatherAPI.repository.WeatherRepository;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping(path = "weather")
@AllArgsConstructor
public class WeatherApiRestController {

    private final WeatherRepository weatherRepository;

    @GetMapping
    public ResponseEntity<?> getAllWeathers(@RequestParam(value = "date", required = false)
                                                @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                                            @RequestParam(value = "city", required = false) String city,
                                            @RequestParam(value = "sort", required = false) String sort) {

        List<Weather> list = weatherRepository.findByCityIgnoreCaseAndDate(city,date);

        //sorting
        if(sort != null && sort.equals("date"))
            list.sort(Comparator.comparing(Weather::getDate));
        else if(sort != null && sort.equals("-date"))
            list.sort(Comparator.comparing(Weather::getDate).reversed());

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Weather> addStudent(@Valid @RequestBody Weather weather) {
        return new ResponseEntity<>(weatherRepository.save(weather), HttpStatus.CREATED);
    }

    @GetMapping(path = "{weatherId}")
    public ResponseEntity<?> getWeatherById(@PathVariable Integer weatherId) {
        Optional<Weather> weather = weatherRepository.findById(weatherId);
        return new ResponseEntity<>(weather, weather.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
