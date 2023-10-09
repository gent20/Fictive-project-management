package repository;

import java.util.Optional;

import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsernameOrEmail(String username, String email);
}