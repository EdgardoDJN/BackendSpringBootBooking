package web.programming.flight_booking_api.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import web.programming.flight_booking_api.entities.Booking;
import web.programming.flight_booking_api.entities.BookingStatus;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("SELECT b FROM Booking b WHERE (:firstName is null or b.user.firstName = :firstName) AND (:bookingStatus is null or b.bookingStatus = :bookingStatus)")
    List<Booking> findByCustomerfirstNameAndStatus(@Param("firstName") String firstName, @Param("bookingStatus") BookingStatus bookingStatus);
    @Query("SELECT b FROM Booking b WHERE b.flight.id = :flightId")
    List<Booking> findAllByFlightId(@Param("flightId") Long flightId);
}
