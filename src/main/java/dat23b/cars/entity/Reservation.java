package dat23b.cars.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name="reservations")
public class Reservation extends AdminDetails {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    int id;
    @Column(name="rental_date")
    LocalDate rentalDate;
    @Column(name="return_date")
    LocalDate returnDate;
    @ManyToOne
    Car car;
    @ManyToOne
    Member member;

    public Reservation(Member member, Car car, LocalDate rentalDate) {
        this.member = member;
        this.car = car;
        this.rentalDate = rentalDate;
    }

}
