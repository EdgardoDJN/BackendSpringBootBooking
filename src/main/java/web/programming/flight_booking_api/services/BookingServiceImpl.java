package web.programming.flight_booking_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.programming.flight_booking_api.entities.Booking;
import web.programming.flight_booking_api.entities.BookingStatus;
import web.programming.flight_booking_api.entities.Flight;
import web.programming.flight_booking_api.entities.User;
import web.programming.flight_booking_api.repositories.BookingRepository;
import web.programming.flight_booking_api.repositories.FlightRepository;
import web.programming.flight_booking_api.repositories.UserRepository;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private final BookingRepository bookingRepository;
    @Autowired
    private final FlightRepository flightRepository;
    @Autowired
    private final UserRepository userRepository;
    
    

    public BookingServiceImpl(BookingRepository bookingRepository, FlightRepository flightRepository,
            UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.flightRepository = flightRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Booking create(Long idflight, Long iduser, Booking booking) {
        Flight flight = flightRepository.findById(idflight).orElse(null);
        User user = userRepository.findById(iduser).orElse(null);


        Booking copy =new Booking();
        copy.setBookingStatus(booking.getBookingStatus());
        copy.setPaymentToken(booking.getPaymentToken());
        copy.setCheckedIn(booking.getCheckedIn());
        copy.setCreatedAt(booking.getCreatedAt());
        copy.setBookingReference(booking.getBookingReference());
        copy.setReservedSeat(booking.getReservedSeat());
        copy.setFlight(flight);
        copy.setUser(user);
        return bookingRepository.save(copy);
    }

    /*@Override
    public List<Booking> find1(String firstName, BookingStatus bookingStatus) {
        return bookingRepository.findByCustomerfirstNameAndStatus(firstName, bookingStatus);
    }
    */

    @Override
    public List<Booking> find2(Long flightId) {
        return bookingRepository.findAllByFlightId(flightId);
    }

    @Override
    public Optional<Booking> find3(Long id) {
        return bookingRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        bookingRepository.deleteById(id);
    }
    
}
