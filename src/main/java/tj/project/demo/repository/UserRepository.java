package tj.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tj.project.demo.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
