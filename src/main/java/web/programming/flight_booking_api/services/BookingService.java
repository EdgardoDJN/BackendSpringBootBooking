package web.programming.flight_booking_api.services;

import java.util.List;
import java.util.Optional;

import web.programming.flight_booking_api.entities.Booking;
import web.programming.flight_booking_api.entities.BookingStatus;

public interface BookingService {
    Booking create(Long idflight, Long iduser, Booking booking);
    List<Booking> find1(String firstName, BookingStatus bookingStatus);
    List<Booking> find2(Long flightId);
    Optional<Booking> find3(Long id);
    void delete(Long id);
}
