package com.jonas.weathertest.scheduler;

import com.jonas.weathertest.dao.TemperatureDao;
import com.jonas.weathertest.dao.repository.MeasurementRepository;
import com.jonas.weathertest.entities.Measurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class scheduler {
    @Autowired
    TemperatureDao temperatureDao;
    @Autowired
    MeasurementRepository measurementRepository;

    @Scheduled(cron="0 0 * * * *")
    public void getWeather() {
        Measurement measurement = new Measurement();
        measurement.setTimestamp(LocalDateTime.now());
        measurement.setTemperature(temperatureDao.getTemperature());
        measurementRepository.save(measurement);
    }
}
