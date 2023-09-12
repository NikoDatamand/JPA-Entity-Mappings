package dat23b.cars.service;

import dat23b.cars.dto.ReservationRequest;
import dat23b.cars.dto.ReservationResponse;
import dat23b.cars.entity.Car;
import dat23b.cars.entity.Member;
import dat23b.cars.entity.Reservation;
import dat23b.cars.repository.CarRepo;
import dat23b.cars.repository.MemberRepo;
import dat23b.cars.repository.ReservationRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

    @Service
    public class ReservationService {

        ReservationRepo reservationRepository;
        MemberRepo memberRepository;
        CarRepo carRepository;

        public ReservationService(ReservationRepo reservationRepository, MemberRepo memberRepository, CarRepo carRepository) {
            this.reservationRepository = reservationRepository;
            this.memberRepository = memberRepository;
            this.carRepository = carRepository;
        }

        public ReservationResponse makeReservation(ReservationRequest body){
            if(reservationRepository.existsByCarIdAndRentalDate(body.getCarId(), body.getDateToReserveCar())){
                throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car is already reserved on this day");
            }
            Car car = carRepository.findById(body.getCarId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car with provide id not found"));
            Member member = memberRepository.findById(body.getUsername())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Member with provided username not found"));
            // Check if the reservation date is in the future
            if (body.getDateToReserveCar().isBefore(LocalDate.now())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Reservation date cannot be a date in the past");
            }
            Reservation reservation= new Reservation(member,car,body.getDateToReserveCar());
            reservationRepository.save(reservation);
            return new ReservationResponse();
        }
}
