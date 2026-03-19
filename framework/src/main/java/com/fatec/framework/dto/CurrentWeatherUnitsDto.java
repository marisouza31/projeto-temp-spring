package com.fatec.framework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentWeatherUnitsDto {
    private String time;
    private String interval;
    private String temperature;
    private String windspeed;
    private String winddirection;
    private String is_day;
    private String weathercode;
}
