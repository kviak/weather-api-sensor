package ru.kviak.weatherapisensor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kviak.weatherapisensor.model.Sensor;

public interface SensorRepository extends JpaRepository<Integer, Sensor> {
}
