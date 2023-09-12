package dat23b.cars.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name="cars")
public class Car extends AdminDetails {

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
    @OneToMany(mappedBy = "car", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Reservation> reservations;

}
