package dat23b.cars.config;

import dat23b.cars.entity.Car;
import dat23b.cars.entity.Member;
import dat23b.cars.entity.Reservation;
import dat23b.cars.repository.CarRepo;
import dat23b.cars.repository.MemberRepo;
import dat23b.cars.repository.ReservationRepo;
import dat23b.security.entity.Role;
import dat23b.security.entity.UserWithRoles;
import dat23b.security.repository.UserWithRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DeveloperData implements ApplicationRunner {

    CarRepo carRepo;
    MemberRepo memberRepo;
    ReservationRepo reservationRepo;
    @Autowired
    UserWithRolesRepository userWithRolesRepository;
    final String passwordUsedByAll = "test12";

    public DeveloperData (CarRepo carRepo, MemberRepo memberRepo, ReservationRepo reservationRepo) {
        this.carRepo = carRepo;
        this.memberRepo = memberRepo;
        this.reservationRepo = reservationRepo;
    }

    /*****************************************************************************************
     NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL
     iT'S ONE OF THE TOP SECURITY FLAWS YOU CAN DO
     *****************************************************************************************/
    private void setupUserWithRoleUsers() {

        System.out.println("******************************************************************************");
        System.out.println("******* NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL ************");
        System.out.println("******* REMOVE THIS BEFORE DEPLOYMENT, AND SETUP DEFAULT USERS DIRECTLY  *****");
        System.out.println("**** ** ON YOUR REMOTE DATABASE                 ******************************");
        System.out.println("******************************************************************************");
        UserWithRoles user1 = new UserWithRoles("user1", passwordUsedByAll, "user1@a.dk");
        UserWithRoles user2 = new UserWithRoles("user2", passwordUsedByAll, "user2@a.dk");
        UserWithRoles user3 = new UserWithRoles("user3", passwordUsedByAll, "user3@a.dk");
        UserWithRoles user4 = new UserWithRoles("user4", passwordUsedByAll, "user4@a.dk");
        user1.addRole(Role.USER);
        user1.addRole(Role.ADMIN);
        user2.addRole(Role.USER);
        user3.addRole(Role.ADMIN);
        //No Role assigned to user4
        userWithRolesRepository.save(user1);
        userWithRolesRepository.save(user2);
        userWithRolesRepository.save(user3);
        userWithRolesRepository.save(user4);
    }


    private void generateMembers() {
        List<Member> newMembers = new ArrayList<>(Arrays.asList(
                new Member("bremsespor", "1234", "Bremsespor", "Henning", "Numsehår", "Tyndskids Allé", "Lille Skideby", "1111"),
                new Member("kongen", "1234", "email@gmai.com", "Kong", "Gordon", "Kongevej", "Kongeby", "2222"),
                new Member("racer_enthusiast", "1234", "raceren7@hotmail.com", "Mike", "Fartstribe", "Blindvej", "Racerby", "3333"),
                new Member("mig", "1234", "MF@statsministeriet.dk", "Mette", "Frederiksen", "Statsministeriet", "København", "4444")
        ));
        memberRepo.saveAll(newMembers);
    }

    private void generateCars() {
        List<Car> newCars = new ArrayList<>(Arrays.asList(
                Car.builder().brand("Toyota").model("Yaris").pricePrDay(100).bestDiscount(10).build(),
                Car.builder().brand("Toyota").model("Corolla").pricePrDay(200).bestDiscount(20).build(),
                Car.builder().brand("Toyota").model("Camry").pricePrDay(300).bestDiscount(30).build(),
                Car.builder().brand("Toyota").model("Supra").pricePrDay(400).bestDiscount(40).build(),
                Car.builder().brand("Toyota").model("Land Cruiser").pricePrDay(500).bestDiscount(50).build(),
                Car.builder().brand("Toyota").model("Prius").pricePrDay(600).bestDiscount(60).build(),
                Car.builder().brand("Toyota").model("RAV4").pricePrDay(700).bestDiscount(70).build(),
                Car.builder().brand("Audi").model("A1").pricePrDay(100).bestDiscount(10).build(),
                Car.builder().brand("Lada").model("Niva").pricePrDay(100).bestDiscount(10).build(),
                Car.builder().brand("BMW").model("M3").pricePrDay(100).bestDiscount(10).build(),
                Car.builder().brand("BMW").model("M5").pricePrDay(100).bestDiscount(10).build(),
                Car.builder().brand("Suzuki").model("Swift").pricePrDay(100).bestDiscount(10).build(),
                Car.builder().brand("Suzuki").model("Jimny").pricePrDay(100).bestDiscount(10).build(),
                Car.builder().brand("Suzuki").model("Vitara").pricePrDay(100).bestDiscount(10).build(),
                Car.builder().brand("Dacia").model("Sandero").pricePrDay(100).bestDiscount(10).build(),
                Car.builder().brand("Dacia").model("Duster").pricePrDay(100).bestDiscount(10).build(),
                Car.builder().brand("Dacia").model("Logan").pricePrDay(100).bestDiscount(10).build(),
                Car.builder().brand("Trabant").model("601").pricePrDay(100).bestDiscount(10).build(),
                Car.builder().brand("Skoda").model("Octavia").pricePrDay(100).bestDiscount(10).build(),
                Car.builder().brand("Skoda").model("Fabia").pricePrDay(100).bestDiscount(10).build(),
                Car.builder().brand("Skoda").model("Superb").pricePrDay(100).bestDiscount(10).build(),
                Car.builder().brand("Chrysler").model("300C").pricePrDay(100).bestDiscount(10).build(),
                Car.builder().brand("Chrysler").model("Voyager").pricePrDay(100).bestDiscount(10).build(),
                Car.builder().brand("Chrysler").model("PT Cruiser").pricePrDay(100).bestDiscount(10).build(),
                Car.builder().brand("Tesla").model("Model S").pricePrDay(100).bestDiscount(10).build(),
                Car.builder().brand("Tesla").model("Model 3").pricePrDay(100).bestDiscount(10).build(),
                Car.builder().brand("Tesla").model("Model X").pricePrDay(100).bestDiscount(10).build()
                ));
        carRepo.saveAll(newCars);
    }



    private void generateReservations () {
        List<Reservation> newReservations = new ArrayList<>(Arrays.asList(
                Reservation.builder().car(carRepo.findById(3).get()).member(memberRepo.findById("bremsespor").get()).rentalDate(LocalDate.of(2021, 10, 10)).returnDate(LocalDate.of(2021, 10, 15)).build(),
                Reservation.builder().car(carRepo.findById(5).get()).member(memberRepo.findById("kongen").get()).rentalDate(LocalDate.of(2021, 10, 10)).returnDate(LocalDate.of(2021, 10, 15)).build(),
                Reservation.builder().car(carRepo.findById(5).get()).member(memberRepo.findById("racer_enthusiast").get()).rentalDate(LocalDate.of(2021, 10, 10)).returnDate(LocalDate.of(2021, 10, 15)).build(),
                Reservation.builder().car(carRepo.findById(8).get()).member(memberRepo.findById("mig").get()).rentalDate(LocalDate.of(2021, 10, 10)).returnDate(LocalDate.of(2021, 10, 15)).build(),
                Reservation.builder().car(carRepo.findById(12).get()).member(memberRepo.findById("bremsespor").get()).rentalDate(LocalDate.of(2021, 10, 10)).returnDate(LocalDate.of(2021, 10, 15)).build(),
                Reservation.builder().car(carRepo.findById(15).get()).member(memberRepo.findById("kongen").get()).rentalDate(LocalDate.of(2021, 10, 10)).returnDate(LocalDate.of(2021, 10, 15)).build(),
                Reservation.builder().car(carRepo.findById(2).get()).member(memberRepo.findById("racer_enthusiast").get()).rentalDate(LocalDate.of(2021, 10, 10)).returnDate(LocalDate.of(2021, 10, 15)).build()
        ));
        reservationRepo.saveAll(newReservations);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        setupUserWithRoleUsers();
        generateMembers();
        generateCars();
        generateReservations();
    }

}
