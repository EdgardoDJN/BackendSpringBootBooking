package web.programming.flight_booking_api.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArrivalDto2 {
    private String arrivalTime;
    private String arrivalCity;
}
