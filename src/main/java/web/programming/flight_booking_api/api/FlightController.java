package web.programming.flight_booking_api.api;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import web.programming.flight_booking_api.api.dto.FlightCreateDto;
import web.programming.flight_booking_api.api.dto.FlightDto;
import web.programming.flight_booking_api.api.dto.FlightMapper;
import web.programming.flight_booking_api.entidades.Flight;
import web.programming.flight_booking_api.exceptions.FlightNotFoundException;
import web.programming.flight_booking_api.services.FlightService;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/model")
public class FlightController {
    @Autowired
    private final FlightService flightService;
    @Autowired
    private final FlightMapper flightMapper;
    public FlightController(FlightService flightService, FlightMapper flightMapper) {
        this.flightService = flightService;
        this.flightMapper = flightMapper;
    }
    @GetMapping("/flight")
    public ResponseEntity<List<FlightCreateDto>> FlightsSearch1(@RequestParam String departureAirportCode, @RequestParam String arrivalAirportCode, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate departureDate
    )
    {
        List<Flight> flights = flightService.FlightsSearch1(departureAirportCode, arrivalAirportCode, departureDate);
        List<FlightCreateDto> flightsDto = flightMapper.tCreateDto(flights);
        if(flights.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(flightsDto);
    }

    @GetMapping("/flight1/{id}")
    public ResponseEntity<FlightCreateDto> getFlightById(@PathVariable Long id)
    {
            FlightCreateDto data = flightService.find(id)
                        .map(t -> flightMapper.toCreateDto(t))
                        .orElseThrow(FlightNotFoundException::new);
    
            return ResponseEntity.status(HttpStatus.FOUND).body(data);
    }

    @GetMapping("/flight2/{departureAirportCode}")
    public ResponseEntity<List<FlightCreateDto>> FlightsSearch2(@PathVariable String departureAirportCode, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate departureDate
    )
    {
        List<Flight> flights = flightService.FlightsSearch2(departureAirportCode, departureDate);
        List<FlightCreateDto> flightsDto = flightMapper.tCreateDto(flights);
        if(flights.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(flightsDto);
    }
    @GetMapping("/flight2")
    public ResponseEntity<List<FlightCreateDto>> FlightsSearch3()
    {
        List<Flight> flights = flightService.findAll();
        List<FlightCreateDto> flightsDto = flightMapper.tCreateDto(flights);
        if(flights.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(flightsDto);
    }
    @PostMapping("/flight")
    public ResponseEntity<FlightCreateDto> createFlight(@RequestBody FlightDto flightDto)
    {
       Flight flight = flightMapper.toEntity(flightDto);
       Flight flightCreated = flightService.create(flight);
       FlightCreateDto flightCreatedDto = flightMapper.toCreateDto(flightCreated);
       if(flightCreated == null)
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
       else{
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(flightCreated.getId()).toUri();
            return ResponseEntity.created(location).body(flightCreatedDto);
        }

    }
    @PutMapping("/flight/{id}")
    public ResponseEntity<FlightCreateDto> updateFlight(@PathVariable Long id, @RequestBody FlightDto flightDto)
    {
        flightService.find(id).orElseThrow(FlightNotFoundException::new);
        Flight flight = flightMapper.toEntity(flightDto);
        Flight flightUpdated = flightService.update(id, flight).get();
        FlightCreateDto flightUpdatedDto = flightMapper.toCreateDto(flightUpdated);
        return ResponseEntity.status(HttpStatus.OK).body(flightUpdatedDto);
        
    }
    @DeleteMapping("/flight/{id}")
    public ResponseEntity<FlightCreateDto> deleteFlight(@PathVariable Long id)
    {
        flightService.find(id).orElseThrow(FlightNotFoundException::new);
        flightService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
}
