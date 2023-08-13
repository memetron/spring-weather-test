package com.jonas.weathertest.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "MEASUREMENT")
@Getter
@Setter
@Table(name = "MEASUREMENT")
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int temperature;
    private LocalDateTime timestamp;

    @Override
    public String toString() {
        return "MeasurementEntity{" +
                "id=" + id +
                ", temperature=" + temperature +
                ", timestamp=" + timestamp +
                '}';
    }
}
