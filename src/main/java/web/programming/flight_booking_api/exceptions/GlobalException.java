package web.programming.flight_booking_api.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> userNotFoundHandler( UserNotFoundException ex, 
                            WebRequest wr){
        ErrorResponse error = new ErrorResponse();
        error.setErrroCode(HttpStatus.NOT_FOUND.value());
        error.setLocalDateTime(LocalDateTime.now());
        error.setMessage(ex.getMessage());
        error.setDescription(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(FlightNotFoundException.class)
    public ResponseEntity<ErrorResponse> flightNotFoundHandler( FlightNotFoundException ex, 
                            WebRequest wr){
        ErrorResponse error = new ErrorResponse();
        error.setErrroCode(HttpStatus.NOT_FOUND.value());
        error.setLocalDateTime(LocalDateTime.now());
        error.setMessage(ex.getMessage());
        error.setDescription(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<ErrorResponse> bookingNotFoundHandler( BookingNotFoundException ex, 
                            WebRequest wr){
        ErrorResponse error = new ErrorResponse();
        error.setErrroCode(HttpStatus.NOT_FOUND.value());
        error.setLocalDateTime(LocalDateTime.now());
        error.setMessage(ex.getMessage());
        error.setDescription(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(ArrivalNotFoundException.class)
    public ResponseEntity<ErrorResponse> arrivalNotFoundHandler( ArrivalNotFoundException ex, 
                            WebRequest wr){
        ErrorResponse error = new ErrorResponse();
        error.setErrroCode(HttpStatus.NOT_FOUND.value());
        error.setLocalDateTime(LocalDateTime.now());
        error.setMessage(ex.getMessage());
        error.setDescription(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(DepartureNotFoundException.class)
    public ResponseEntity<ErrorResponse> departureNotFoundHandler( DepartureNotFoundException ex, 
                            WebRequest wr){
        ErrorResponse error = new ErrorResponse();
        error.setErrroCode(HttpStatus.NOT_FOUND.value());
        error.setLocalDateTime(LocalDateTime.now());
        error.setMessage(ex.getMessage());
        error.setDescription(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
