package ru.kviak.weatherapisensor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kviak.weatherapisensor.model.Sensor;

import java.util.Optional;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {
    Optional<Sensor> findByName(String name);
}
