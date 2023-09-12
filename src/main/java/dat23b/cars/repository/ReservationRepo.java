package dat23b.cars.repository;

import dat23b.cars.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Integer> {

    boolean existsByCarIdAndRentalDate(int carId, LocalDate rentalDate);
}
