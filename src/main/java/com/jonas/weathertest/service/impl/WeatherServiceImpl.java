package com.jonas.weathertest.service.impl;

import com.jonas.weathertest.dao.repository.MeasurementRepository;
import com.jonas.weathertest.entities.Measurement;
import com.jonas.weathertest.service.WeatherService;
import dto.MeasurementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    MeasurementRepository measurementRepository;
    @Override
    public double averageWeather() {
        LocalDateTime present = LocalDateTime.now();
        List<Integer> temperatures = measurementRepository
                .findAllByTimestampBetween(present.minus(1, ChronoUnit.DAYS), present)
                .stream().map(measurement -> measurement.getTemperature())
                .toList();
        return temperatures.stream().reduce(Integer::sum).get() / temperatures.size();
    }

    @Override
    public void inputMeasurement(MeasurementDTO measurementDTO) {
        Measurement measurement = new Measurement();
        measurement.setTimestamp(measurementDTO.getTime());
        measurement.setTemperature(measurementDTO.getTemperature());
        measurementRepository.save(measurement);
    }
}
