package web.programming.flight_booking_api.services;

import java.util.List;
import java.util.Optional;

import web.programming.flight_booking_api.entities.Departure;

public interface DepartureService {
    Departure create(Departure departure);
    Optional<Departure> update(Long id, Departure departure);
    List<Departure> findAll();
    Optional<Departure> find(Long id);
    void delete(Long id);
}
