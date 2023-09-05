package dat23b.cars.service;

import dat23b.cars.dto.CarRequest;
import dat23b.cars.dto.CarResponse;
import dat23b.cars.entity.Car;
import dat23b.cars.repository.CarRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    CarRepo carRepo;

    //Generate methods based on the MemberService class
    public CarService(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public List<CarResponse> getCars(boolean includeAll) {
        List<Car> cars = carRepo.findAll();
        List<CarResponse> response = new ArrayList<>();
        for (Car car : cars) {
            CarResponse cr = new CarResponse(car, includeAll);
            response.add(cr);
        }
        return response;
    }

    public CarResponse getCarById(int id, boolean includeAll) throws Exception {
        Car car = carRepo.findById(id).orElseThrow(() -> new Exception("Car not found"));
        return new CarResponse(car, true);
    }

    public CarResponse addCar(CarRequest body) {
        Car newCar = CarRequest.getCarEntity(body);
        newCar = carRepo.save(newCar);
        return new CarResponse(newCar, true);
    }

    public void deleteCarById(int id) {
        carRepo.deleteById(id);
    }
}
