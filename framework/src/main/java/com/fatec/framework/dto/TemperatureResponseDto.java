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
    @JsonProperty("dataHora")
    private Date time;

    @JsonProperty("temperaturaDia")
    private double temperature;

    @JsonProperty("umidadeDia")
    private double dayHumidity;

    @JsonProperty("vento")
    private double windSpeed;

    @JsonProperty("unidadeVento")
    private String windUnit;
}
