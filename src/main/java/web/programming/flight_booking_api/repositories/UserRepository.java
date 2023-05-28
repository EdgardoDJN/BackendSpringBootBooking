package web.programming.flight_booking_api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import web.programming.flight_booking_api.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {
    Optional<User> findByUsername(String username);
    //Esto es pa que no nos genere el error
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
