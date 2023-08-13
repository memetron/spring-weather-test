package com.jonas.weathertest.dao.impl;

import com.jayway.jsonpath.JsonPath;
import com.jonas.weathertest.config.TemperatureConfig;
import com.jonas.weathertest.dao.TemperatureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TemperatureDaoImpl implements TemperatureDao {
    @Autowired
    TemperatureConfig temperatureConfig;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public int getTemperature() {
        String response = restTemplate.getForObject(
                temperatureConfig.getUrl(),
                String.class
        );
        return JsonPath.read(response, temperatureConfig.getPathToResponse());
    }
}
