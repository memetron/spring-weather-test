package com.jonas.weathertest.controller;

import com.jonas.weathertest.dao.TemperatureDao;
import com.jonas.weathertest.dao.repository.MeasurementRepository;
import com.jonas.weathertest.entities.Measurement;
import com.jonas.weathertest.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("weather/api/v1")
public class WeatherController {
    @Autowired
    TemperatureDao temperatureDao;
    @Autowired
    MeasurementRepository measurementRepository;
    @Autowired
    WeatherService weatherService;

    @GetMapping("get-weather")
    public void getWeather() {
        Measurement measurement = new Measurement();
        measurement.setTimestamp(LocalDateTime.now());
        measurement.setTemperature(temperatureDao.getTemperature());
        measurementRepository.save(measurement);
    }

    @GetMapping("average-weather")
    public ResponseEntity<String> averageWeather() {
        return ResponseEntity.ok(String.format("{\"average\":%s}", weatherService.averageWeather()));
    }
}
