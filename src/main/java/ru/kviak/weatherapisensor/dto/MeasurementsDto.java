package ru.kviak.weatherapisensor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementsDto {
    private BigDecimal value;
    private boolean raining;
    private SensorDto sensor;

}
