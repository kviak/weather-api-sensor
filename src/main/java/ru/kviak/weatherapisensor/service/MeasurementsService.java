package ru.kviak.weatherapisensor.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kviak.weatherapisensor.dto.MeasurementsDto;
import ru.kviak.weatherapisensor.dto.RainyDaysCount;
import ru.kviak.weatherapisensor.model.Measurements;
import ru.kviak.weatherapisensor.model.Sensor;
import ru.kviak.weatherapisensor.repository.MeasurementsRepository;
import ru.kviak.weatherapisensor.repository.SensorRepository;
import ru.kviak.weatherapisensor.util.error.SensorNotFound;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MeasurementsService {
    private final ModelMapper mapper;
    private final MeasurementsRepository measurementsRepository;
    private final SensorRepository sensorRepository;


    @Transactional
    public MeasurementsDto add(MeasurementsDto dto){
        Sensor owner = sensorRepository.findByName(dto.getSensor().getName()).orElseThrow(SensorNotFound::new);
        Measurements measurements = mapper.map(dto, Measurements.class);
        measurements.setSensor(owner);
        measurementsRepository.save(measurements);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<MeasurementsDto> get(){
        List<MeasurementsDto> dtoList = new ArrayList<>();
        for (Measurements m:measurementsRepository.findAll()) {
            dtoList.add(mapper.map(m, MeasurementsDto.class)); // Change to StreamAPI
        }
        return dtoList;
    }

    @Transactional(readOnly = true)
    public RainyDaysCount getRainyCount(){
        return new RainyDaysCount((measurementsRepository.getAllByRainingTrue().size()));
    }
}
