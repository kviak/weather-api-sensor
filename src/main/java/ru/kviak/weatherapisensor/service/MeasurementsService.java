package ru.kviak.weatherapisensor.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kviak.weatherapisensor.dto.MeasurementsDto;
import ru.kviak.weatherapisensor.dto.RainyDaysCountDto;
import ru.kviak.weatherapisensor.model.Measurements;
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
        Measurements measurements = mapper.map(dto, Measurements.class);
        measurements.setSensor(sensorRepository.findByName(dto.getSensor().getName())
                .orElseThrow(SensorNotFound::new));
        measurementsRepository.save(measurements);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<MeasurementsDto> get(){
        List<MeasurementsDto> dtoList = new ArrayList<>();
        measurementsRepository.findAll().forEach((k) -> // Get all measurements, and mapping to dto class.
                dtoList.add(mapper.map(k, MeasurementsDto.class)));
        return dtoList;
    }

    @Transactional(readOnly = true)
    public RainyDaysCountDto getRainyCount(){
        return new RainyDaysCountDto(measurementsRepository.countByRainingTrue());
    }
}
