package com.fatec.domain.entity;

import java.util.Date;

public class Temperature {
    private Date time;
    private double temperature;
    private double dayHumidity;
    private double windSpeed;
    private String windUnit;

    public Temperature() {
    }

    public Temperature(Date time, double temperature, double dayHumidity, double windSpeed, String windUnit) {
        this.time = time;
        this.temperature = temperature;
        this.dayHumidity = dayHumidity;
        this.windSpeed = windSpeed;
        this.windUnit = windUnit;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getDayHumidity() {
        return dayHumidity;
    }

    public void setDayHumidity(double dayHumidity) {
        this.dayHumidity = dayHumidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindUnit() {
        return windUnit;
    }

    public void setWindUnit(String windUnit) {
        this.windUnit = windUnit;
    }
}
