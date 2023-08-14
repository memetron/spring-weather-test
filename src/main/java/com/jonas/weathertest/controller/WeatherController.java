package com.jonas.weathertest.controller;

import com.jonas.weathertest.dao.TemperatureDao;
import com.jonas.weathertest.dao.repository.MeasurementRepository;
import com.jonas.weathertest.service.WeatherService;
import dto.MeasurementDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("weather/api/v1")
public class WeatherController {
    @Autowired
    TemperatureDao temperatureDao;
    @Autowired
    MeasurementRepository measurementRepository;
    @Autowired
    WeatherService weatherService;

    @GetMapping("average-weather")
    public ResponseEntity<String> averageWeather() {
        return ResponseEntity.ok(String.format("{\"average\":%s}", weatherService.averageWeather()));
    }

    @PostMapping("input-measurement")
    public ResponseEntity<String> inputMeasurement(@RequestBody MeasurementDTO measurement) {
        weatherService.inputMeasurement(measurement);
        return ResponseEntity.ok("{}");
    }
}
