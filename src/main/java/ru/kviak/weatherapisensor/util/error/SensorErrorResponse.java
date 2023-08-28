package ru.kviak.weatherapisensor.util.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
public class SensorErrorResponse {
    private String message;
    private Instant instant;
}
