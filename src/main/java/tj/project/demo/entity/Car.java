package tj.project.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cars")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "user_id")
    private Long userId;

    private String brand;
    private String model;
    private String color;
    private String year;
    private double engineCapacity;
    private String fuelType;
    private int power;
    private double torque;
    private int trunkVolume;
    private int price;
}
