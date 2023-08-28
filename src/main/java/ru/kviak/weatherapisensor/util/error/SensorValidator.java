package ru.kviak.weatherapisensor.util.error;

import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kviak.weatherapisensor.dto.SensorDto;
import ru.kviak.weatherapisensor.repository.SensorRepository;


@Component
@RequiredArgsConstructor
public class SensorValidator implements Validator {
    private final SensorRepository sensorRepository;
    @Override
    public boolean supports(Class<?> clazz) {
        return SensorDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SensorDto sensorDto = (SensorDto) target;
       if(sensorRepository.findByName(sensorDto.getName()).isPresent()) {
           errors.rejectValue("Name", "400", "This name is already taken!");
       }
    }
}
