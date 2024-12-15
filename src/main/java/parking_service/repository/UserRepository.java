package parking_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parking_service.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);

    boolean existsByLogin(String login);
}