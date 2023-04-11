package web.programming.flight_booking_api.exceptions;

public class FlightNotFoundException extends RuntimeException {

    public FlightNotFoundException() {
        super("El vuelo asignado a ese id no se encuentra registrado.");
    }

    public FlightNotFoundException(String message) {
        super(message);
    }
    
    

}