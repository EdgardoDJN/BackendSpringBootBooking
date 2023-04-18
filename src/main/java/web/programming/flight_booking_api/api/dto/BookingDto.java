package web.programming.flight_booking_api.api.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import web.programming.flight_booking_api.entities.BookingStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    private BookingStatus bookingStatus;
    private String paymentToken;
    private Boolean checkedIn;
    private LocalDate createdAt;
    private String bookingReference;
    private int reservedSeat;
}
