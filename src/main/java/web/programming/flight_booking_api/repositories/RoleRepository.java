package web.programming.flight_booking_api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import web.programming.flight_booking_api.entities.ERole;
import web.programming.flight_booking_api.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
