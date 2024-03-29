package web.programming.flight_booking_api.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import web.programming.flight_booking_api.entities.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    //@Query("SELECT v FROM Flight v WHERE v.departureAirportCode = :departureAirportCode AND v.arrivalAirportCode = :arrivalAirportCode AND v.departureDate = :departureDate")
    //List<Flight> FlightsSearch(@Param("departureAirportCode") String departureAirportCode, @Param("arrivalAirportCode") String arrivalAirportCode, @Param("departureDate") LocalDate departureDate);
    @Query("SELECT f FROM Flight f WHERE f.departure.departureAirportCode = :departureAirportCode AND f.arrival.arrivalAirportCode = :arrivalAirportCode AND f.departure.departureDate = :departureDate")
    List<Flight> FlightsSearch1(@Param("departureAirportCode") String departureAirportCode, @Param("arrivalAirportCode") String arrivalAirportCode, @Param("departureDate") LocalDate departureDate);
    @Query("SELECT f FROM Flight f WHERE f.departure.departureAirportCode = :departureAirportCode AND f.departure.departureDate = :departureDate")
    List<Flight> flightsByAirportAndDate(@Param("departureAirportCode") String departureAirportCode, @Param("departureDate") LocalDate departureDate);
    @Query("SELECT f FROM Flight f WHERE f.departure.departureAirportName = :departureAirportName AND f.arrival.arrivalAirportName = :arrivalAirportName AND f.departure.departureDate = :departureDate")
    List<Flight> FlightsSearch3(@Param("departureAirportName") String departureAirportName, @Param("arrivalAirportName") String arrivalAirportName, @Param("departureDate") String departureDate);

}
