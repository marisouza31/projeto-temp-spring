package com.fatec.framework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemperatureResponseDto {
    @JsonProperty("data_hora")
    private Date time;

    @JsonProperty("temperatura_dia")
    private double temperature;

    @JsonProperty("umidade_dia")
    private double dayHumidity;

    @JsonProperty("vento")
    private double windSpeed;

    @JsonProperty("unidade_vento")
    private String windUnit;
}
