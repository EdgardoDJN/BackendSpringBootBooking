package web.programming.flight_booking_api.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.programming.flight_booking_api.entities.Flight;
import web.programming.flight_booking_api.repositories.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    private final FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }
    @Override
    public Flight create(Flight flight) {
        Flight copy = new Flight(
            null,
            flight.getTicketPrice(),
            flight.getTicketCurrency(),
            flight.getFlightNumber(),
            flight.getSeatCapacity(),
            flight.getAirlineName(),
            flight.getFlightClass(),
            flight.getDeparture(),
            flight.getArrival(),
            null
        );
        return flightRepository.save(copy);
    }

    @Override
    public Optional<Flight> update(Long id, Flight flight) {
        return flightRepository.findById(id).map(f -> {
            f.setTicketPrice(flight.getTicketPrice());
            f.setTicketCurrency(flight.getTicketCurrency());
            f.setFlightNumber(flight.getFlightNumber());
            f.setSeatCapacity(flight.getSeatCapacity());
            f.setAirlineName(flight.getAirlineName());
            f.setFlightClass(flight.getFlightClass());
            f.setDeparture(flight.getDeparture());
            f.setArrival(flight.getArrival());
            return flightRepository.save(f);
        });
    }

    @Override
    public List<Flight> FlightsSearch1(String departureAirportCode, String arrivalAirportCode,
            LocalDate departureDate) {
        return flightRepository.FlightsSearch(
            departureAirportCode,
            arrivalAirportCode,
            departureDate
        );
    }

    @Override
    public List<Flight> FlightsSearch2(String departureAirportCode, LocalDate departureDate) {
        return flightRepository.flightsByAirportAndDate(departureAirportCode, departureDate);
    }
    
    @Override
    public void delete(Long id) {
        flightRepository.deleteById(id);

    }
    @Override
    public Optional<Flight> find(Long id) {
        return flightRepository.findById(id);
    }
    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }
    
}
