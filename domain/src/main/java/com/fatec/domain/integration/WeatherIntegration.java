package com.fatec.domain.integration;

import com.fatec.domain.entity.LocationWeather;

public interface WeatherIntegration {
    LocationWeather getWeatherByCords(double lat, double lon);
}
