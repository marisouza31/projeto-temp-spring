package com.fatec.framework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherResponseDto {
    private double latitude;
    private double longitude;
    private double generationtime_ms;
    private int utc_offset_seconds;
    private String timezone;
    private String timezone_abbreviation;
    private int elevation;

    @JsonProperty("current_weather_units")
    private CurrentWeatherUnitsDto currentWeatherUnits;

    @JsonProperty("current_weather")
    private CurrentWeatherDto currentWeather;
}
