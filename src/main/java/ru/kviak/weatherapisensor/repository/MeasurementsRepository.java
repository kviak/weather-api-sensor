package ru.kviak.weatherapisensor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kviak.weatherapisensor.model.Measurements;

import java.util.List;


public interface MeasurementsRepository extends JpaRepository<Measurements, Integer> {

    List<Measurements> getAllByRainingTrue();
}
