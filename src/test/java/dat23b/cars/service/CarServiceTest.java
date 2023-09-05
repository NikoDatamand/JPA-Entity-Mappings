package dat23b.cars.service;

import dat23b.cars.dto.CarRequest;
import dat23b.cars.dto.CarResponse;
import dat23b.cars.entity.Car;
import dat23b.cars.repository.CarRepo;
import dat23b.cars.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@ActiveProfiles("test")
public class CarServiceTest {

    @Autowired
    private CarRepo carRepo;

    private CarService carService;

    @BeforeEach
    public void setUp() {
        carService = new CarService(carRepo);
    }

    @Test
    public void testAddCar() {
        // Arrange
        CarRequest carRequest = new CarRequest("Car1", "Make1", 100.0, 10);

        // Act
        CarResponse carResponse = carService.addCar(carRequest);

        // Assert
        Car savedCar = carRepo.findById(carResponse.getId()).orElse(null);
        assertThat(savedCar).isNotNull();
        assertThat(savedCar.getBrand()).isEqualTo("Car1");
        assertThat(savedCar.getModel()).isEqualTo("Make1");
        assertThat(savedCar.getPricePrDay()).isEqualTo(100.0);
        assertThat(savedCar.getBestDiscount()).isEqualTo(10);
    }

    @Test
    public void testGetCars() {
        // Arrange
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Car1", "Make1", 100.0, 10));
        cars.add(new Car("Car2", "Make2", 120.0, 12));
        cars.add(new Car("Car3", "Make3", 90.0, 8));
        carRepo.saveAll(cars);

        // Act
        List<CarResponse> carResponses = carService.getCars(true);

        // Assert
        assertThat(carResponses).hasSize(3);
        assertThat(carResponses.get(0).getBrand()).isEqualTo("Car1");
        assertThat(carResponses.get(1).getBrand()).isEqualTo("Car2");
        assertThat(carResponses.get(2).getBrand()).isEqualTo("Car3");
    }

    @Test
    public void testGetCarById_ExistingId() throws Exception {
        // Arrange
        Car car = new Car("Car1", "Make1", 100.0, 10);
        carRepo.save(car);

        // Act
        CarResponse carResponse = carService.getCarById(car.getId(), true);

        // Assert
        assertThat(carResponse).isNotNull();
        assertThat(carResponse.getBrand()).isEqualTo("Car1");
        assertThat(carResponse.getModel()).isEqualTo("Make1");
        assertThat(carResponse.getPricePrDay()).isEqualTo(100.0);
        assertThat(carResponse.getBestDiscount()).isEqualTo(10);
    }

    @Test
    public void testGetCarById_NonExistingId() {
        // Arrange (no car in the database)

        // Act & Assert
        Exception exception = org.junit.jupiter.api.Assertions.assertThrows(Exception.class, () -> {
            carService.getCarById(1, true);
        });

        assertThat(exception.getMessage()).isEqualTo("Car not found");
    }

    @Test
    public void testDeleteCarById() {
        // Arrange
        Car car = new Car("Car1", "Make1", 100.0, 10);
        carRepo.save(car);

        // Act
        carService.deleteCarById(car.getId());

        // Assert
        Optional<Car> deletedCar = carRepo.findById(car.getId());
        assertThat(deletedCar).isEmpty();
    }
}