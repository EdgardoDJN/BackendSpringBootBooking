package web.programming.flight_booking_api.api.dto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import web.programming.flight_booking_api.entities.Arrival;
import web.programming.flight_booking_api.entities.Departure;
import web.programming.flight_booking_api.entities.Flight;

@Component
public class FlightMapper {
    public FlightDto toDto(Flight flight) {
        FlightDto dto = new FlightDto();
        dto.setTicketPrice(flight.getTicketPrice());
        dto.setTicketCurrency(flight.getTicketCurrency());
        dto.setFlightNumber(flight.getFlightNumber());
        dto.setSeatCapacity(flight.getSeatCapacity());
        dto.setAirlineName(flight.getAirlineName());
        dto.setFlightClass(flight.getFlightClass());

        DepartureCreateDto departureCreateDto = new DepartureCreateDto();
        departureCreateDto.setId(flight.getDeparture().getId());
        departureCreateDto.setDepartureDate(flight.getDeparture().getDepartureDate());
        departureCreateDto.setDepartureAirportCode(flight.getDeparture().getDepartureAirportCode());
        departureCreateDto.setDepartureAirportName(flight.getDeparture().getDepartureAirportName());
        departureCreateDto.setDepartureCity(flight.getDeparture().getDepartureCity());
        departureCreateDto.setDepartureLocale(flight.getDeparture().getDepartureLocale());
        dto.setDeparture(departureCreateDto);

        ArrivalCreateDto arrivalCreateDto = new ArrivalCreateDto();
        arrivalCreateDto.setId(flight.getArrival().getId());
        arrivalCreateDto.setArrivalDate(flight.getArrival().getArrivalDate());
        arrivalCreateDto.setArrivalAirportCode(flight.getArrival().getArrivalAirportCode());
        arrivalCreateDto.setArrivalAirportName(flight.getArrival().getArrivalAirportName());
        arrivalCreateDto.setArrivalCity(flight.getArrival().getArrivalCity());
        arrivalCreateDto.setArrivalLocale(flight.getArrival().getArrivalLocale());
        dto.setArrival(arrivalCreateDto);

        return dto;
    }
    public FlightCreateDto toCreateDto (Flight flight) {
        FlightCreateDto dto = new FlightCreateDto();
        dto.setId(flight.getId());
        dto.setTicketPrice(flight.getTicketPrice());
        dto.setTicketCurrency(flight.getTicketCurrency());
        dto.setFlightNumber(flight.getFlightNumber());
        dto.setSeatCapacity(flight.getSeatCapacity());
        dto.setAirlineName(flight.getAirlineName());
        dto.setFlightClass(flight.getFlightClass());

        DepartureCreateDto departureCreateDto = new DepartureCreateDto();
        departureCreateDto.setId(flight.getDeparture().getId());
        departureCreateDto.setDepartureDate(flight.getDeparture().getDepartureDate());
        departureCreateDto.setDepartureAirportCode(flight.getDeparture().getDepartureAirportCode());
        departureCreateDto.setDepartureAirportName(flight.getDeparture().getDepartureAirportName());
        departureCreateDto.setDepartureCity(flight.getDeparture().getDepartureCity());
        departureCreateDto.setDepartureLocale(flight.getDeparture().getDepartureLocale());
        dto.setDeparture(departureCreateDto);

        ArrivalCreateDto arrivalCreateDto = new ArrivalCreateDto();
        arrivalCreateDto.setId(flight.getArrival().getId());
        arrivalCreateDto.setArrivalDate(flight.getArrival().getArrivalDate());
        arrivalCreateDto.setArrivalAirportCode(flight.getArrival().getArrivalAirportCode());
        arrivalCreateDto.setArrivalAirportName(flight.getArrival().getArrivalAirportName());
        arrivalCreateDto.setArrivalCity(flight.getArrival().getArrivalCity());
        arrivalCreateDto.setArrivalLocale(flight.getArrival().getArrivalLocale());
        dto.setArrival(arrivalCreateDto);

        return dto;
    }
    public Flight toEntity(FlightDto dto) {
        Flight flight = new Flight();
        flight.setTicketPrice(dto.getTicketPrice());
        flight.setTicketCurrency(dto.getTicketCurrency());
        flight.setFlightNumber(dto.getFlightNumber());
        flight.setSeatCapacity(dto.getSeatCapacity());
        flight.setAirlineName(dto.getAirlineName());
        flight.setFlightClass(dto.getFlightClass());

        Departure departure = new Departure();
        departure.setId(dto.getDeparture().getId());
        departure.setDepartureDate(dto.getDeparture().getDepartureDate());
        departure.setDepartureAirportCode(dto.getDeparture().getDepartureAirportCode());
        departure.setDepartureAirportName(dto.getDeparture().getDepartureAirportName());
        departure.setDepartureCity(dto.getDeparture().getDepartureCity());
        departure.setDepartureLocale(dto.getDeparture().getDepartureLocale());
        flight.setDeparture(departure);

        Arrival arrival = new Arrival();
        arrival.setId(dto.getArrival().getId());
        arrival.setArrivalDate(dto.getArrival().getArrivalDate());
        arrival.setArrivalAirportCode(dto.getArrival().getArrivalAirportCode());
        arrival.setArrivalAirportName(dto.getArrival().getArrivalAirportName());
        arrival.setArrivalCity(dto.getArrival().getArrivalCity());
        arrival.setArrivalLocale(dto.getArrival().getArrivalLocale());
        flight.setArrival(arrival);

        return flight;
    }
    public FlightCreateDto toCreateDto(Optional<Flight> flight) {
        FlightCreateDto dto = new FlightCreateDto();
        dto.setId(flight.get().getId());
        dto.setTicketPrice(flight.get().getTicketPrice());
        dto.setTicketCurrency(flight.get().getTicketCurrency());
        dto.setFlightNumber(flight.get().getFlightNumber());
        dto.setSeatCapacity(flight.get().getSeatCapacity());
        dto.setAirlineName(flight.get().getAirlineName());
        dto.setFlightClass(flight.get().getFlightClass());

        DepartureCreateDto departureCreateDto = new DepartureCreateDto();
        departureCreateDto.setId(flight.get().getDeparture().getId());
        departureCreateDto.setDepartureDate(flight.get().getDeparture().getDepartureDate());
        departureCreateDto.setDepartureAirportCode(flight.get().getDeparture().getDepartureAirportCode());
        departureCreateDto.setDepartureAirportName(flight.get().getDeparture().getDepartureAirportName());
        departureCreateDto.setDepartureCity(flight.get().getDeparture().getDepartureCity());
        departureCreateDto.setDepartureLocale(flight.get().getDeparture().getDepartureLocale());
        dto.setDeparture(departureCreateDto);

        ArrivalCreateDto arrivalCreateDto = new ArrivalCreateDto();
        arrivalCreateDto.setId(flight.get().getArrival().getId());
        arrivalCreateDto.setArrivalDate(flight.get().getArrival().getArrivalDate());
        arrivalCreateDto.setArrivalAirportCode(flight.get().getArrival().getArrivalAirportCode());
        arrivalCreateDto.setArrivalAirportName(flight.get().getArrival().getArrivalAirportName());
        arrivalCreateDto.setArrivalCity(flight.get().getArrival().getArrivalCity());
        arrivalCreateDto.setArrivalLocale(flight.get().getArrival().getArrivalLocale());
        dto.setArrival(arrivalCreateDto);

        return dto;
    }
    public List<FlightCreateDto> tCreateDto(List<Flight> flights)
    {
        List<FlightCreateDto> flightCreateDtos = flights.stream().map(this::toCreateDto).collect(Collectors.toList());
        return flightCreateDtos;
    }

}
