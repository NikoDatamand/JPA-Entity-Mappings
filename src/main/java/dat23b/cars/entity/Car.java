package dat23b.cars.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="cars")
public class Car {

    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name="car_brand", length= 50, nullable = false)
    private String brand;
    @Column(name="car_model", length= 60, nullable = false)
    private String model;
    @Column(name="rental_price_day")
    private double pricePrDay;
    @Column(name="max_discount")
    private int bestDiscount;

    @Column(name="created")
    @CreationTimestamp
    private LocalDateTime created;
    @Column(name="last_updated")
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    //Constructors
    public Car() {

    }

    public Car(String brand, String model, double pricePrDay, int bestDiscount) {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
        this.bestDiscount = bestDiscount;
    }


}
