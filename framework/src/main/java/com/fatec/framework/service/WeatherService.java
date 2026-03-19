package com.fatec.framework.service;

import org.springframework.stereotype.Service;
import com.fatec.framework.client.WeatherClient;
import com.fatec.framework.dto.WeatherResponseDto;
import com.fatec.framework.dto.LocationWeatherResponseDto;
import com.fatec.framework.dto.TemperatureResponseDto;
import com.fatec.framework.repository.WeatherQueryEntity;
import com.fatec.framework.repository.WeatherQueryRepository;
import com.fatec.domain.entity.LocationWeather;
import com.fatec.domain.entity.Temperature;
import lombok.RequiredArgsConstructor;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;
    private final WeatherQueryRepository weatherQueryRepository;

    public LocationWeatherResponseDto getWeatherByCordinates(double latitude, double longitude) {
        WeatherResponseDto response = weatherClient.getWeather(latitude, longitude, true);

        LocationWeather locationWeather = convertToLocationWeather(response);
        persistQuery(latitude, longitude, locationWeather);

        return convertToResponseDto(locationWeather);
    }

    private void persistQuery(double latitude, double longitude, LocationWeather locationWeather) {
        Temperature temperature = locationWeather.getTemperature();

        WeatherQueryEntity entity = new WeatherQueryEntity();
        entity.setLatitude(latitude);
        entity.setLongitude(longitude);
        entity.setTimezone(locationWeather.getTimezone());
        entity.setWeatherTime(temperature.getTime());
        entity.setTemperature(temperature.getTemperature());
        entity.setDayHumidity(temperature.getDayHumidity());
        entity.setWindSpeed(temperature.getWindSpeed());
        entity.setWindUnit(temperature.getWindUnit());
        entity.setRequestedAt(new Date());

        weatherQueryRepository.save(entity);
    }

    private LocationWeather convertToLocationWeather(WeatherResponseDto response) {
        LocationWeather locationWeather = new LocationWeather();
        locationWeather.setTimezone(response.getTimezone());

        Temperature temperature = new Temperature();

        try {
            SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            Date time = isoFormat.parse(response.getCurrentWeather().getTime());
            temperature.setTime(time);
        } catch (Exception e) {
            temperature.setTime(new Date());
        }

        temperature.setTemperature(response.getCurrentWeather().getTemperature());
        temperature.setWindSpeed(response.getCurrentWeather().getWindspeed());
        temperature.setWindUnit(response.getCurrentWeatherUnits().getWindspeed());
        temperature.setDayHumidity(0.0); // A API não fornece umidade direta

        locationWeather.setTemperature(temperature);

        return locationWeather;
    }

    private LocationWeatherResponseDto convertToResponseDto(LocationWeather locationWeather) {
        LocationWeatherResponseDto responseDto = new LocationWeatherResponseDto();
        responseDto.setTimezone(locationWeather.getTimezone());

        Temperature temperature = locationWeather.getTemperature();
        TemperatureResponseDto temperatureDto = new TemperatureResponseDto();
        temperatureDto.setTime(temperature.getTime());
        temperatureDto.setTemperature(temperature.getTemperature());
        temperatureDto.setDayHumidity(temperature.getDayHumidity());
        temperatureDto.setWindSpeed(temperature.getWindSpeed());
        temperatureDto.setWindUnit(temperature.getWindUnit());

        responseDto.setTemperature(temperatureDto);

        return responseDto;
    }
}
