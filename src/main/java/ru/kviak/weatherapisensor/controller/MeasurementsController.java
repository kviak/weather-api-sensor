package ru.kviak.weatherapisensor.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kviak.weatherapisensor.dto.MeasurementsDto;
import ru.kviak.weatherapisensor.dto.RainyDaysCount;
import ru.kviak.weatherapisensor.service.MeasurementsService;
import ru.kviak.weatherapisensor.util.error.SensorErrorResponse;
import ru.kviak.weatherapisensor.util.error.SensorNotFound;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/measurements")
@RequiredArgsConstructor
public class MeasurementsController {
    private final MeasurementsService measurementsService;

    @PostMapping("/add")
    public ResponseEntity<MeasurementsDto> handle(@RequestBody MeasurementsDto dto){
        return ResponseEntity.ok(measurementsService.add(dto));
    }

    @GetMapping()
    public ResponseEntity<List<MeasurementsDto>> get(){
        return ResponseEntity.ok(measurementsService.get());
    }


    @GetMapping("/rayniDaysCount")
    public ResponseEntity<RainyDaysCount> rainyDaysCount(){
        return ResponseEntity.ok(measurementsService.getRainyCount());
    }

    @ExceptionHandler
    private ResponseEntity<SensorErrorResponse> handleException(SensorNotFound e){
        SensorErrorResponse response = new SensorErrorResponse(
                "Sensor with this name wasn't found!",
                Instant.now()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
