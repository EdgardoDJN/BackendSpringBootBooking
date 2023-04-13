package web.programming.flight_booking_api.api;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.programming.flight_booking_api.api.dto.DepartureCreateDto;
import web.programming.flight_booking_api.api.dto.DepartureDto;
import web.programming.flight_booking_api.api.dto.DepartureMapper;
import web.programming.flight_booking_api.entidades.Departure;
import web.programming.flight_booking_api.exceptions.DepartureNotFoundException;
import web.programming.flight_booking_api.services.DepartureService;

@RestController
@RequestMapping("/api/model")
public class DepartureController {
    @Autowired
    private final DepartureService departureService;
    @Autowired
    private final DepartureMapper departureMapper;
    public DepartureController(DepartureService departureService, DepartureMapper departureMapper) {
        this.departureService = departureService;
        this.departureMapper = departureMapper;
    }
    @GetMapping("/departure")
    public ResponseEntity<List<DepartureCreateDto>> getAllDepartures()
    {
        List<Departure> departures = departureService.findAll();
        List<DepartureCreateDto> departuresDto = departures.stream().map(departureMapper::toCreateDto).collect(Collectors.toList());
        if(departuresDto.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(departuresDto);
        else
        {
            return ResponseEntity.ok(departuresDto);
        }
    }
    @GetMapping("/departure/{id}")
    public ResponseEntity<DepartureCreateDto> getDepartureById(@PathVariable Long id)
    {
        DepartureCreateDto data = departureService.find(id)
                    .map(t -> departureMapper.toCreateDto(t))
                    .orElseThrow(DepartureNotFoundException::new);

        return ResponseEntity.status(HttpStatus.FOUND).body(data);
    }
    @PostMapping("/departure")
    public ResponseEntity<DepartureCreateDto> createDeparture(@RequestBody DepartureDto departureDto)
    {
        Departure departure = departureMapper.toEntity(departureDto);
        Departure departureCreated = departureService.create(departure);
        DepartureCreateDto departureCreatedDto = departureMapper.toCreateDto(departureCreated);
        if(departureCreatedDto == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(departureCreatedDto);
        else
            return ResponseEntity.status(HttpStatus.CREATED).body(departureCreatedDto);
    }
    @PutMapping("/departure/{id}")
    public ResponseEntity<DepartureCreateDto> updateDeparture(@PathVariable Long id, @RequestBody DepartureDto departureDto)
    {
        Departure departure = departureMapper.toEntity(departureDto);
        departureService.find(id).orElseThrow(DepartureNotFoundException::new);
        Optional<Departure> departureUpdated = departureService.update(id, departure);
        DepartureCreateDto departureUpdatedDto = departureMapper.toCreateDto(departureUpdated);
        return ResponseEntity.status(HttpStatus.OK).body(departureUpdatedDto);
    }
    @DeleteMapping("/departure/{id}")
    public ResponseEntity<Void> deleteDeparture(@PathVariable Long id)
    {
        departureService.find(id).orElseThrow(DepartureNotFoundException::new);
        departureService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
