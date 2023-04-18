package web.programming.flight_booking_api.api.dto;



import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import web.programming.flight_booking_api.entities.BookingStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookingCreateDto {
    private Long id;
    private BookingStatus bookingStatus;
    private FlightCreateDto flight;
    private String paymentToken;
    private Boolean checkedIn;
    private UserCreateDto user;
    private LocalDate createdAt;
    private String bookingReference;
    private int reservedSeat;
}
