package com.fatec.framework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentWeatherDto {
    private String time;
    private int interval;
    private double temperature;
    private double windspeed;
    private int winddirection;
    private int is_day;
    private int weathercode;
}
