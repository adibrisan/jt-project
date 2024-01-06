package tj.project.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tj.project.demo.entity.Car;
import tj.project.demo.repository.CarRepository;
import tj.project.demo.specification.CarSpecifications;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public ResponseEntity<Car> addCar(String registrationNumber, Car newCar){
        Car existingCar = carRepository.findByRegistrationNumber(registrationNumber);
        if (existingCar != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        newCar.setRegistrationNumber(registrationNumber);
        Car savedCar = carRepository.save(newCar);
        return ResponseEntity.ok().body(savedCar);
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public ResponseEntity<String> deleteCar(String registrationNumber) {
        Optional<Car> existingCar = carRepository.findById(registrationNumber);

        if (existingCar.isPresent()) {
            carRepository.deleteById(registrationNumber);
            return ResponseEntity.ok("Car deleted successfully.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found.");
    }


    public ResponseEntity<Car> updateCar(String registrationNumber, Car car) {
        if (carRepository.existsById(registrationNumber)) {
            car.setRegistrationNumber(registrationNumber);
            Car updatedCar = carRepository.save(car);
            return ResponseEntity.ok(updatedCar);
        }
        return ResponseEntity.notFound().build();
    }

    // interogation
    public List<Car> getFilteredCars(String brand, String color, Integer year) {
        Specification<Car> spec = CarSpecifications.filterByBrandColorYear(brand, color, year);
        return carRepository.findAll(spec);
    }

}
