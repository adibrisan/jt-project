package tj.project.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private String user;
    private String password;
    private int levelAccess;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Car> cars = new ArrayList<>();
}
