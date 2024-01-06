package tj.project.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId",insertable = false,updatable = false)
    @JsonIgnore
    private User user;
}
