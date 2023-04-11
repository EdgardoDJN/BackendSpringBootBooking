package web.programming.flight_booking_api.api.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import web.programming.flight_booking_api.entidades.FlightClass;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightCreateDto {
    private Long id;
    private int ticketPrice;
    private String ticketCurrency;
    private int flightNumber;
    private int seatCapacity;
    private String airlineName;
    private FlightClass flightClass;
    private DepartureCreateDto departure;
    private ArrivalCreateDto arrival;
}
