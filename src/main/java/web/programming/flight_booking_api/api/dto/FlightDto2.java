package web.programming.flight_booking_api.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import web.programming.flight_booking_api.entities.FlightClass;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDto2 {
    private Long id;
    private int ticketPrice;
    private String ticketCurrency;
    private int flightNumber;
    private DepartureDto2 departure;
    private ArrivalDto2 arrival;
    private String duration;
}
