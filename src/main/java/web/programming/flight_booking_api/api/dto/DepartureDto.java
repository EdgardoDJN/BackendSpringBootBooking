package web.programming.flight_booking_api.api.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartureDto {
    private LocalDate departureDate;
    private String departureAirportCode;
    private String departureAirportName;
    private String departureCity;
    private String departureLocale;
}
