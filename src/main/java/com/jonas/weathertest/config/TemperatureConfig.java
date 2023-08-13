package com.jonas.weathertest.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("temperature")
@Getter
@Setter
public class TemperatureConfig {
    private String url;
    private String pathToResponse;
}
