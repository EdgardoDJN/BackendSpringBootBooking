package web.programming.flight_booking_api.exceptions;

public class BookingNotFoundException extends RuntimeException {

    public BookingNotFoundException() {
        super("La reserva asignada a ese id no se encuentra registrada.");
    }

    public BookingNotFoundException(String message) {
        super(message);
    }
    
    

}