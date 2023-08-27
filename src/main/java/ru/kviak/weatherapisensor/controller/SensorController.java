package ru.kviak.weatherapisensor.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kviak.weatherapisensor.dto.SensorDto;
import ru.kviak.weatherapisensor.service.SensorService;

@RequestMapping("/api/v1/sensors")
@RequiredArgsConstructor
@RestController
public class SensorController {
    private final SensorService sensorService;

    @PostMapping("/registration")
    public ResponseEntity<SensorDto> handle(@RequestBody SensorDto dto){
        return ResponseEntity.ok(sensorService.save(dto));
    }
}
