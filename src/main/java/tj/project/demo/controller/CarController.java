package tj.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tj.project.demo.entity.Car;
import tj.project.demo.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/{registrationNumber}")
    public ResponseEntity<Car> addCar(@PathVariable String registrationNumber, @RequestBody Car newCar){
        return carService.addCar(registrationNumber,newCar);
    }

    @GetMapping
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @DeleteMapping("/{registrationNumber}")
    public ResponseEntity<String> deleteCar(@PathVariable String registrationNumber){
        return carService.deleteCar(registrationNumber);
    }

    @PutMapping("/{registrationNumber}")
    public ResponseEntity<Car> updateCar(@PathVariable String registrationNumber,@RequestBody Car car){
        return carService.updateCar(registrationNumber,car);
    }

    @GetMapping("/filter-cars")
    public List<Car> getFilteredCars(@RequestParam(required = false) String brand,@RequestParam(required = false) String color,@RequestParam(required = false) Integer year) {
        return carService.getFilteredCars(brand,color,year);
    }
}
