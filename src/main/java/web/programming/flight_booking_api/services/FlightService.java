package web.programming.flight_booking_api.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import web.programming.flight_booking_api.entities.Flight;

public interface FlightService {
    Flight create(Flight flight);
    Optional<Flight> update(Long id, Flight flight);
    List<Flight> findAll();
    List<Flight> FlightsSearch1(String departureAirportCode, String arrivalAirportCode, LocalDate departureDate);
    List<Flight> FlightsSearch2(String departureAirportCode, LocalDate departureDate);
    Optional<Flight> find(Long id);
    void delete(Long id);
}
