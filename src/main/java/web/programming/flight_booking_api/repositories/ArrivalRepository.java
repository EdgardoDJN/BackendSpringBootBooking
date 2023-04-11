package web.programming.flight_booking_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import web.programming.flight_booking_api.entidades.Arrival;

@Repository
public interface ArrivalRepository extends JpaRepository<Arrival, Long> {
    
}
