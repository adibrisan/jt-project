package tj.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tj.project.demo.entity.Car;

public interface CarRepository extends JpaRepository<Car,String> {
    Car findByRegistrationNumber(String registrationNumber);
    void deleteById(String registrationNumber);
}
