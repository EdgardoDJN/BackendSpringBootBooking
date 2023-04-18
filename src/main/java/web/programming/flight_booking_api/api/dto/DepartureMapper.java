package web.programming.flight_booking_api.api.dto;

import java.util.Optional;

import org.springframework.stereotype.Component;

import web.programming.flight_booking_api.entities.Departure;

@Component
public class DepartureMapper {
    public DepartureDto toDto(Departure departure)
    {
        DepartureDto departureDto = new DepartureDto();
        departureDto.setDepartureDate(departure.getDepartureDate());
        departureDto.setDepartureAirportCode(departure.getDepartureAirportCode());
        departureDto.setDepartureAirportName(departure.getDepartureAirportName());
        departureDto.setDepartureCity(departure.getDepartureCity());
        departureDto.setDepartureLocale(departure.getDepartureLocale());
        return departureDto;
    }
    public Departure toEntity(DepartureDto departureDto)
    {
        Departure departure = new Departure();
        departure.setDepartureDate(departureDto.getDepartureDate());
        departure.setDepartureAirportCode(departureDto.getDepartureAirportCode());
        departure.setDepartureAirportName(departureDto.getDepartureAirportName());
        departure.setDepartureCity(departureDto.getDepartureCity());
        departure.setDepartureLocale(departureDto.getDepartureLocale());
        return departure;
    }
    public DepartureCreateDto toCreateDto(Departure departure)
    {
        DepartureCreateDto departureCreateDto = new DepartureCreateDto();
        departureCreateDto.setId(departure.getId());
        departureCreateDto.setDepartureDate(departure.getDepartureDate());
        departureCreateDto.setDepartureAirportCode(departure.getDepartureAirportCode());
        departureCreateDto.setDepartureAirportName(departure.getDepartureAirportName());
        departureCreateDto.setDepartureCity(departure.getDepartureCity());
        departureCreateDto.setDepartureLocale(departure.getDepartureLocale());
        return departureCreateDto;
    }
    public DepartureDto toDto(Optional<Departure> departure)
    {
        DepartureDto departureDto = new DepartureDto();
        departureDto.setDepartureDate(departure.get().getDepartureDate());
        departureDto.setDepartureAirportCode(departure.get().getDepartureAirportCode());
        departureDto.setDepartureAirportName(departure.get().getDepartureAirportName());
        departureDto.setDepartureCity(departure.get().getDepartureCity());
        departureDto.setDepartureLocale(departure.get().getDepartureLocale());
        return departureDto;
    }
    public DepartureCreateDto toCreateDto(Optional<Departure> departure)
    {
        DepartureCreateDto departureCreateDto = new DepartureCreateDto();
        departureCreateDto.setId(departure.get().getId());
        departureCreateDto.setDepartureDate(departure.get().getDepartureDate());
        departureCreateDto.setDepartureAirportCode(departure.get().getDepartureAirportCode());
        departureCreateDto.setDepartureAirportName(departure.get().getDepartureAirportName());
        departureCreateDto.setDepartureCity(departure.get().getDepartureCity());
        departureCreateDto.setDepartureLocale(departure.get().getDepartureLocale());
        return departureCreateDto;
    }
}
