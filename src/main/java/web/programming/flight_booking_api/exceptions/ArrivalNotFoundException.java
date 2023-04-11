package web.programming.flight_booking_api.exceptions;

public class ArrivalNotFoundException extends RuntimeException {

    public ArrivalNotFoundException() {
        super("La llegada asignada a ese id no se encuentra registrada.");
    }

    public ArrivalNotFoundException(String message) {
        super(message);
    }
    
    

}