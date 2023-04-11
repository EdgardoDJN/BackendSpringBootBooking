package web.programming.flight_booking_api.api.dto;

import java.util.Optional;

import org.springframework.stereotype.Component;

import web.programming.flight_booking_api.entidades.Arrival;

@Component
public class ArrivalMapper {
    public ArrivalDto tDto(Arrival arrival)
    {
        ArrivalDto arrivalDto = new ArrivalDto();
        arrivalDto.setArrivalDate(arrival.getArrivalDate());
        arrivalDto.setArrivalAirportCode(arrival.getArrivalAirportCode());
        arrivalDto.setArrivalAirportName(arrival.getArrivalAirportName());
        arrivalDto.setArrivalCity(arrival.getArrivalCity());
        arrivalDto.setArrivalLocale(arrival.getArrivalLocale());
        return arrivalDto;
    }
    public Arrival toEntity(ArrivalDto arrivalDto)
    {
        Arrival arrival = new Arrival();
        arrival.setArrivalDate(arrivalDto.getArrivalDate());
        arrival.setArrivalAirportCode(arrivalDto.getArrivalAirportCode());
        arrival.setArrivalAirportName(arrivalDto.getArrivalAirportName());
        arrival.setArrivalCity(arrivalDto.getArrivalCity());
        arrival.setArrivalLocale(arrivalDto.getArrivalLocale());
        return arrival;
    }
    public ArrivalCreateDto toCreateDto(Arrival arrival)
    {
        ArrivalCreateDto arrivalCreateDto = new ArrivalCreateDto();
        arrivalCreateDto.setId(arrival.getId());
        arrivalCreateDto.setArrivalDate(arrival.getArrivalDate());
        arrivalCreateDto.setArrivalAirportCode(arrival.getArrivalAirportCode());
        arrivalCreateDto.setArrivalAirportName(arrival.getArrivalAirportName());
        arrivalCreateDto.setArrivalCity(arrival.getArrivalCity());
        arrivalCreateDto.setArrivalLocale(arrival.getArrivalLocale());
        return arrivalCreateDto;
    }
    public ArrivalDto toDto(Optional<Arrival> arrival)
    {
        ArrivalDto arrivalDto = new ArrivalDto();
        arrivalDto.setArrivalDate(arrival.get().getArrivalDate());
        arrivalDto.setArrivalAirportCode(arrival.get().getArrivalAirportCode());
        arrivalDto.setArrivalAirportName(arrival.get().getArrivalAirportName());
        arrivalDto.setArrivalCity(arrival.get().getArrivalCity());
        arrivalDto.setArrivalLocale(arrival.get().getArrivalLocale());
        return arrivalDto;
    }
    public ArrivalCreateDto toCreateDto(Optional<Arrival> arrival)
    {
        ArrivalCreateDto arrivalCreateDto = new ArrivalCreateDto();
        arrivalCreateDto.setId(arrival.get().getId());
        arrivalCreateDto.setArrivalDate(arrival.get().getArrivalDate());
        arrivalCreateDto.setArrivalAirportCode(arrival.get().getArrivalAirportCode());
        arrivalCreateDto.setArrivalAirportName(arrival.get().getArrivalAirportName());
        arrivalCreateDto.setArrivalCity(arrival.get().getArrivalCity());
        arrivalCreateDto.setArrivalLocale(arrival.get().getArrivalLocale());
        return arrivalCreateDto;
    }
}
