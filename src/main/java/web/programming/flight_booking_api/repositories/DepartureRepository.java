package web.programming.flight_booking_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import web.programming.flight_booking_api.entities.Departure;

@Repository
public interface DepartureRepository extends JpaRepository<Departure, Long> {
    
}
