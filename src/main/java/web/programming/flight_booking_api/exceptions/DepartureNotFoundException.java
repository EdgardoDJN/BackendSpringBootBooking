package web.programming.flight_booking_api.exceptions;

public class DepartureNotFoundException extends RuntimeException {

    public DepartureNotFoundException() {
        super("La salida asignada a ese id no se encuentra registrada.");
    }

    public DepartureNotFoundException(String message) {
        super(message);
    }
    
    

}