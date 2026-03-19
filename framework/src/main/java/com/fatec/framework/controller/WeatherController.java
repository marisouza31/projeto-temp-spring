package com.fatec.framework.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import com.fatec.framework.service.WeatherService;
import com.fatec.framework.dto.LocationWeatherResponseDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/location")
    public LocationWeatherResponseDto getWeatherByLocation(
            @RequestParam("latitude") String latitude,
            @RequestParam("longitude") String longitude) {
        double lat = parseCoordinate(latitude, "latitude");
        double lon = parseCoordinate(longitude, "longitude");

        if (lat < -90 || lat > 90) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Latitude deve estar entre -90 e 90");
        }
        if (lon < -180 || lon > 180) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Longitude deve estar entre -180 e 180");
        }

        return weatherService.getWeatherByCordinates(lat, lon);
    }

    private double parseCoordinate(String value, String fieldName) {
        try {
            String normalized = value.trim().replace(',', '.');
            return Double.parseDouble(normalized);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Parametro invalido para " + fieldName + ": " + value);
        }
    }

}
