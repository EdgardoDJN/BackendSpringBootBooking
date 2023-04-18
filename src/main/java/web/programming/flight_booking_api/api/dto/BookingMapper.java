package web.programming.flight_booking_api.api.dto;

import java.util.Optional;

import org.springframework.stereotype.Component;

import web.programming.flight_booking_api.entities.Booking;

@Component
public class BookingMapper {
    public BookingDto toDto(Booking booking)
    {
        BookingDto bookingDto = new BookingDto();
        bookingDto.setBookingStatus(booking.getBookingStatus());
        bookingDto.setPaymentToken(booking.getPaymentToken());
        bookingDto.setCheckedIn(booking.getCheckedIn());
        bookingDto.setCreatedAt(booking.getCreatedAt());
        bookingDto.setBookingReference(booking.getBookingReference());
        bookingDto.setReservedSeat(booking.getReservedSeat());
        return bookingDto;
    }
    public BookingCreateDto toCreateDto(Booking booking)
    {
        BookingCreateDto bookingCreateDto = new BookingCreateDto();
        bookingCreateDto.setId(booking.getId());
        bookingCreateDto.setBookingStatus(booking.getBookingStatus());
        bookingCreateDto.setPaymentToken(booking.getPaymentToken());
        bookingCreateDto.setCheckedIn(booking.getCheckedIn());
        bookingCreateDto.setCreatedAt(booking.getCreatedAt());
        bookingCreateDto.setBookingReference(booking.getBookingReference());
        bookingCreateDto.setReservedSeat(booking.getReservedSeat());
        FlightCreateDto flightCreateDto = new FlightCreateDto();
        flightCreateDto.setId(booking.getFlight().getId());
        flightCreateDto.setTicketPrice(booking.getFlight().getTicketPrice());
        flightCreateDto.setTicketCurrency(booking.getFlight().getTicketCurrency());
        flightCreateDto.setFlightNumber(booking.getFlight().getFlightNumber());
        flightCreateDto.setSeatCapacity(booking.getFlight().getSeatCapacity());
        flightCreateDto.setAirlineName(booking.getFlight().getAirlineName());
        flightCreateDto.setFlightClass(booking.getFlight().getFlightClass());
        DepartureCreateDto departureCreateDto = new DepartureCreateDto();
        departureCreateDto.setId(booking.getFlight().getDeparture().getId());
        departureCreateDto.setDepartureDate(booking.getFlight().getDeparture().getDepartureDate());
        departureCreateDto.setDepartureAirportCode(booking.getFlight().getDeparture().getDepartureAirportCode());
        departureCreateDto.setDepartureAirportName(booking.getFlight().getDeparture().getDepartureAirportName());
        departureCreateDto.setDepartureCity(booking.getFlight().getDeparture().getDepartureCity());
        departureCreateDto.setDepartureLocale(booking.getFlight().getDeparture().getDepartureLocale());
        flightCreateDto.setDeparture(departureCreateDto);
        ArrivalCreateDto arrivalCreateDto = new ArrivalCreateDto();
        arrivalCreateDto.setId(booking.getFlight().getArrival().getId());
        arrivalCreateDto.setArrivalDate(booking.getFlight().getArrival().getArrivalDate());
        arrivalCreateDto.setArrivalAirportCode(booking.getFlight().getArrival().getArrivalAirportCode());
        arrivalCreateDto.setArrivalAirportName(booking.getFlight().getArrival().getArrivalAirportName());
        arrivalCreateDto.setArrivalCity(booking.getFlight().getArrival().getArrivalCity());
        arrivalCreateDto.setArrivalLocale(booking.getFlight().getArrival().getArrivalLocale());
        flightCreateDto.setArrival(arrivalCreateDto);
        UserCreateDto userCreateDto = new UserCreateDto();
        userCreateDto.setId(booking.getUser().getId());
        userCreateDto.setFirstName(booking.getUser().getFirstName());
        userCreateDto.setLastName(booking.getUser().getLastName());
        userCreateDto.setUserName(booking.getUser().getUserName());
        userCreateDto.setPassword(booking.getUser().getPassword());
        userCreateDto.setDateofbirth(booking.getUser().getDateofbirth());
        userCreateDto.setPhoneNumber(booking.getUser().getPhoneNumber());
        bookingCreateDto.setFlight(flightCreateDto);
        bookingCreateDto.setUser(userCreateDto);
        return bookingCreateDto;
    }
    public Booking toEntity(BookingDto bookingDto)
    {
        Booking booking = new Booking();
        booking.setBookingStatus(bookingDto.getBookingStatus());
        booking.setPaymentToken(bookingDto.getPaymentToken());
        booking.setCheckedIn(bookingDto.getCheckedIn());
        booking.setCreatedAt(bookingDto.getCreatedAt());
        booking.setBookingReference(bookingDto.getBookingReference());
        booking.setReservedSeat(bookingDto.getReservedSeat());
        return booking;
    }
    public BookingCreateDto toCreateDto(Optional<Booking> booking)
    {
        BookingCreateDto bookingCreateDto = new BookingCreateDto();
        bookingCreateDto.setId(booking.get().getId());
        bookingCreateDto.setBookingStatus(booking.get().getBookingStatus());
        FlightCreateDto flightCreateDto = new FlightCreateDto();
        flightCreateDto.setId(booking.get().getFlight().getId());
        flightCreateDto.setTicketPrice(booking.get().getFlight().getTicketPrice());
        flightCreateDto.setTicketCurrency(booking.get().getFlight().getTicketCurrency());
        flightCreateDto.setFlightNumber(booking.get().getFlight().getFlightNumber());
        flightCreateDto.setSeatCapacity(booking.get().getFlight().getSeatCapacity());
        flightCreateDto.setAirlineName(booking.get().getFlight().getAirlineName());
        DepartureCreateDto departureCreateDto = new DepartureCreateDto();
        departureCreateDto.setId(booking.get().getFlight().getDeparture().getId());
        departureCreateDto.setDepartureDate(booking.get().getFlight().getDeparture().getDepartureDate());
        departureCreateDto.setDepartureAirportCode(booking.get().getFlight().getDeparture().getDepartureAirportCode());
        departureCreateDto.setDepartureAirportName(booking.get().getFlight().getDeparture().getDepartureAirportName());
        departureCreateDto.setDepartureCity(booking.get().getFlight().getDeparture().getDepartureCity());
        departureCreateDto.setDepartureLocale(booking.get().getFlight().getDeparture().getDepartureLocale());
        flightCreateDto.setDeparture(departureCreateDto);
        ArrivalCreateDto arrivalCreateDto = new ArrivalCreateDto();
        arrivalCreateDto.setId(booking.get().getFlight().getArrival().getId());
        arrivalCreateDto.setArrivalDate(booking.get().getFlight().getArrival().getArrivalDate());
        arrivalCreateDto.setArrivalAirportCode(booking.get().getFlight().getArrival().getArrivalAirportCode());
        arrivalCreateDto.setArrivalAirportName(booking.get().getFlight().getArrival().getArrivalAirportName());
        arrivalCreateDto.setArrivalCity(booking.get().getFlight().getArrival().getArrivalCity());
        arrivalCreateDto.setArrivalLocale(booking.get().getFlight().getArrival().getArrivalLocale());
        flightCreateDto.setArrival(arrivalCreateDto);
        bookingCreateDto.setFlight(flightCreateDto);
        return bookingCreateDto;
    }
}
