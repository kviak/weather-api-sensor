package ru.kviak.weatherapisensor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kviak.weatherapisensor.model.Measurements;


public interface MeasurementsRepository extends JpaRepository<Integer, Measurements> {
}
