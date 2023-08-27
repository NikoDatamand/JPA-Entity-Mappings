package dat23b.cars.config;

import dat23b.cars.entity.Car;
import dat23b.cars.repository.CarRepo;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DeveloperData implements ApplicationRunner {

    CarRepo carRepo;
    public DeveloperData (CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //create a list of cars
        List<Car> cars = new ArrayList<>();
        //add cars to the list with brand and model, where the price is ranged between 500.00 and 5000.00 and the discount is ranged between 10 and 50
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
        //add 30 more cars to the list with brand and model, where the price is ranged between 500.00 and 5000.00 and the discount is ranged between 10 and 50
        cars.add(new Car("Tesla", "Model S", 500.00, 10));
        cars.add(new Car("Tesla", "Model 3", 1000.00, 20));
        cars.add(new Car("Tesla", "Model X", 1500.00, 30));
        cars.add(new Car("Subaru", "Impreza", 2000.00, 40));
        cars.add(new Car("Subaru", "Forester", 2500.00, 50));
        cars.add(new Car("Subaru", "Outback", 3000.00, 10));
        cars

        );

    }
}
