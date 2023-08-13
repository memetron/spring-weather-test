package com.jonas.weathertest.dao.repository;

import com.jonas.weathertest.entities.Measurement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Repository
public interface MeasurementRepository extends CrudRepository<Measurement, Integer> {
     ArrayList<Measurement> findAllByTimestampBetween(LocalDateTime start, LocalDateTime end);
}
