package dat23b.cars.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat23b.cars.entity.Car;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarRequest {
    String brand;
    String model;
    double pricePrDay;
    int bestDiscount;

    public static Car getCarEntity(CarRequest c){
        return new Car(c.brand, c.model, c.pricePrDay, c.bestDiscount);
    }

    public CarRequest(String brand, String model, double pricePrDay, int bestDiscount) {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
        this.bestDiscount = bestDiscount;
    }

}
