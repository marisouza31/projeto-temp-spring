package com.fatec.domain.entity;

public class LocationWeather {
    private String timezone;
    private Temperature temperature;

    public LocationWeather() {
    }

    public LocationWeather(String timezone, Temperature temperature) {
        this.timezone = timezone;
        this.temperature = temperature;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }
}
