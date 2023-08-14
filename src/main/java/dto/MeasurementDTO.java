package dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MeasurementDTO {
    private int temperature;
    private LocalDateTime time;
}
