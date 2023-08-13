package com.jonas.weathertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableScheduling
@EnableJpaRepositories
public class WeatherTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherTestApplication.class, args);
	}
	@Bean
	public RestTemplate createRestTemplate() {
		return new RestTemplate();
	}
}
