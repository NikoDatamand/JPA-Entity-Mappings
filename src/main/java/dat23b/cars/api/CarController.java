package dat23b.cars.api;

import dat23b.cars.dto.CarRequest;
import dat23b.cars.dto.CarResponse;
import dat23b.cars.dto.MemberRequest;
import dat23b.cars.dto.MemberResponse;
import dat23b.cars.entity.Car;
import dat23b.cars.service.CarService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarController {

    CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    //Access type: all
    @GetMapping
    List<CarResponse> getCars() {
        return carService.getCars(false);
    }

    //Access type: all
    @GetMapping(path = "/{id}")
    CarResponse getCarById(@PathVariable int id) throws Exception {
        return carService.getCarById(id, false);

    }

    //Access type: admin
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CarResponse addCar(@RequestBody CarRequest body){
        return carService.addCar(body);
    }

    //Access type: admin
    @DeleteMapping("/{id}")
    void deleteCarById(@PathVariable int id) {
        carService.deleteCarById(id);
    }

}


