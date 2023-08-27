package ru.kviak.weatherapisensor.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kviak.weatherapisensor.dto.SensorDto;
import ru.kviak.weatherapisensor.model.Sensor;
import ru.kviak.weatherapisensor.repository.SensorRepository;

@Service
@RequiredArgsConstructor
public class SensorService {
    private final SensorRepository sensorRepository;
    private final ModelMapper mapper;

    @Transactional
    public SensorDto save(SensorDto dto){
        sensorRepository.save(mapper.map(dto, Sensor.class));
        return dto;
    }

}
