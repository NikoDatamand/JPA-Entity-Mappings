package dat23b.cars.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat23b.cars.entity.Car;
import dat23b.cars.entity.Reservation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarRequest {
        String brand;
        String model;
        double pricePrDay;
        int bestDiscount;

        public static Car createCarEntity (CarRequest cr){
            return Car.builder().brand(cr.brand).model(cr.model).pricePrDay(cr.pricePrDay).bestDiscount(cr.bestDiscount).build();
        }
}
