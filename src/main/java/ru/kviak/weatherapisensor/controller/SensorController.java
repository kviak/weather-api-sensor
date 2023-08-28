package ru.kviak.weatherapisensor.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kviak.weatherapisensor.dto.SensorDto;
import ru.kviak.weatherapisensor.service.SensorService;
import ru.kviak.weatherapisensor.util.error.SensorValidator;

@RequestMapping("/api/v1/sensors")
@RequiredArgsConstructor
@RestController
public class SensorController {
    private final SensorService sensorService;
    private final SensorValidator sensorValidator;

    @PostMapping()
    public ResponseEntity<?> handle(@RequestBody @Valid SensorDto dto, BindingResult bindingResult){
        sensorValidator.validate(dto, bindingResult);
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);}
        return ResponseEntity.ok(sensorService.save(dto));
    }
}
