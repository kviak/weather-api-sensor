package ru.kviak.weatherapisensor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WeatherApiSensorApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApiSensorApplication.class, args);
	}

}
