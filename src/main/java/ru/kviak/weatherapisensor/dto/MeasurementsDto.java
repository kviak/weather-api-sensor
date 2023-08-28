package ru.kviak.weatherapisensor.dto;

import jakarta.validation.constraints.*;
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
    @Min(value = -100, message = "Min temperature -100!")
    @Max(value = 100, message = "Max temperature 100!")
    @NotNull(message = "Value can't be NULL!")
    private BigDecimal value;
    @NotNull(message = "Raining status can't be NULL!")
    private boolean raining;
    @NotNull(message = "Sensor can't be NULL!")
    private SensorDto sensor;
}
