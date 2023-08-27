package dat23b.cars.config;

import dat23b.cars.entity.Car;
import dat23b.cars.entity.Member;
import dat23b.cars.repository.CarRepo;
import dat23b.cars.repository.MemberRepo;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DeveloperData implements ApplicationRunner {

    CarRepo carRepo;
    MemberRepo memberRepo;
    public DeveloperData (CarRepo carRepo, MemberRepo memberRepo) {
        this.carRepo = carRepo;
        this.memberRepo = memberRepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Audi", "A1", 500.00, 10));
        cars.add(new Car("Skoda", "Fabia", 1000.00, 20));
        cars.add(new Car("Volkswagen", "Golf", 1500.00, 30));
        cars.add(new Car("BMW", "X5", 2000.00, 40));
        cars.add(new Car("Mercedes", "C200", 2500.00, 50));
        cars.add(new Car("Audi", "A3", 3000.00, 10));
        cars.add(new Car("Skoda", "Octavia", 3500.00, 20));
        cars.add(new Car("Volkswagen", "Passat", 4000.00, 30));
        cars.add(new Car("Suzuki", "Swift", 4500.00, 40));
        cars.add(new Car("Toyota", "Corolla", 5000.00, 50));
        cars.add(new Car("Tesla", "Model S", 500.00, 10));
        cars.add(new Car("Tesla", "Model 3", 1000.00, 20));
        cars.add(new Car("Tesla", "Model X", 1500.00, 30));
        cars.add(new Car("Subaru", "Impreza", 2000.00, 40));
        cars.add(new Car("Subaru", "Forester", 2500.00, 50));
        cars.add(new Car("Subaru", "Outback", 3000.00, 10));
        cars.add(new Car("Hyundai", "i30", 3500.00, 20));
        cars.add(new Car("Hyundai", "i40", 4000.00, 30));
        cars.add(new Car("Dacia", "Sandero", 4500.00, 40));
        cars.add(new Car("Dacia", "Duster", 5000.00, 50));
        cars.add(new Car("Renault", "Clio", 500.00, 10));
        cars.add(new Car("Renault", "Megane", 1000.00, 20));
        cars.add(new Car("Renault", "Captur", 1500.00, 30));
        cars.add(new Car("Range Rover", "Evoque", 2000.00, 40));
        cars.add(new Car("Range Rover", "Velar", 2500.00, 50));
        carRepo.saveAll(cars);

        List<Member> members = new ArrayList<>();
        members.add(new Member("bremsespor", "1234", "Bremsespor@gmail.com", "Henning", "Numsehår", "Tyndskids Allé", "Lille Skideby", "1111"));
        members.add(new Member("kongen", "1234", "email@gmail.com", "Kong", "Gordon", "Kongevej", "Kongeby", "2222"));
        members.add(new Member("racer_enthusiast", "1234", "raceren7@hotmail.com", "Mike", "Fartstribe", "Blindvej", "Racerby", "3333"));
        members.add(new Member("mig", "1234", "MF@statsministeriet.dk", "Mette", "Frederiksen", "Statsministeriet", "København", "4444"));
        memberRepo.saveAll(members);
    }
}
