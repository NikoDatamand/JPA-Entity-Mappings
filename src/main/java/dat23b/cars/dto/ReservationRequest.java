package dat23b.cars.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ReservationRequest {
    private int carId;
    private String username;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateToReserveCar;
}