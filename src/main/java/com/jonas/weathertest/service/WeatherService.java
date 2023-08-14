package com.jonas.weathertest.service;

import dto.MeasurementDTO;
import org.springframework.stereotype.Service;

public interface WeatherService {
    double averageWeather();

    void inputMeasurement(MeasurementDTO measurement);
}
