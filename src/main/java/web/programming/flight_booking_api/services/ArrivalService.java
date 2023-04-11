package web.programming.flight_booking_api.services;

import java.util.List;
import java.util.Optional;

import web.programming.flight_booking_api.entidades.Arrival;

public interface ArrivalService {
    Arrival create(Arrival arrival);
    Optional<Arrival> update(Long id, Arrival arrival);
    List<Arrival> findAll();
    Optional<Arrival> find(Long id);
    void delete(Long id);
}
