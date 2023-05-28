package web.programming.flight_booking_api.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartureDto2 {
    private String departureTime;
    private String departureCity;
}
