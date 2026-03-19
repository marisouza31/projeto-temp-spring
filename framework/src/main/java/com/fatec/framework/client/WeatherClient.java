package com.fatec.framework.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.UriComponentsBuilder;
import com.fatec.framework.dto.WeatherResponseDto;

@Component
public class WeatherClient {

    @Autowired
    private RestTemplate restTemplate;

    private static final String BASE_URL = "https://api.open-meteo.com/v1/forecast";

    public WeatherResponseDto getWeather(double latitude, double longitude, boolean currentWeather) {
        String url = UriComponentsBuilder.fromUriString(BASE_URL)
                .queryParam("latitude", latitude)
                .queryParam("longitude", longitude)
                .queryParam("current_weather", currentWeather)
                .build()
                .toUriString();

        return restTemplate.getForObject(url, WeatherResponseDto.class);
    }
}
