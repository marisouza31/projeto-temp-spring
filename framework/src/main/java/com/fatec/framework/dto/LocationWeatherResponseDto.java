package com.fatec.framework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationWeatherResponseDto {
    @JsonProperty("tempoZona")
    private String timezone;

    @JsonProperty("temperatura")
    private TemperatureResponseDto temperature;
}
