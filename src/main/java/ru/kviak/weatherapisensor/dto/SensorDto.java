package ru.kviak.weatherapisensor.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SensorDto {
    @NotBlank(message = "Name cannot be empty!")
    @Size(min = 3, message = "Minimal name size 3!")
    private String name;
}
