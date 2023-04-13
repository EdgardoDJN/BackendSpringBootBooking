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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import web.programming.flight_booking_api.api.dto.ArrivalCreateDto;
import web.programming.flight_booking_api.api.dto.ArrivalDto;
import web.programming.flight_booking_api.api.dto.ArrivalMapper;
import web.programming.flight_booking_api.entidades.Arrival;
import web.programming.flight_booking_api.exceptions.ArrivalNotFoundException;
import web.programming.flight_booking_api.services.ArrivalService;

@RestController
@RequestMapping("/api/model")
public class ArrivalController {
    @Autowired
    private final ArrivalService arrivalService;
    @Autowired
    private final ArrivalMapper arrivalMapper;
    
    public ArrivalController(ArrivalService arrivalService, ArrivalMapper arrivalMapper) {
        this.arrivalService = arrivalService;
        this.arrivalMapper = arrivalMapper;
    }
    @GetMapping("/arrival")
    public ResponseEntity<List<ArrivalCreateDto>> getAllArrivals()
    {
        List<Arrival> arrivals = arrivalService.findAll();
        List<ArrivalCreateDto> arrivalsDto = arrivals.stream().map(arrivalMapper::toCreateDto).collect(Collectors.toList());
        if(arrivalsDto.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(arrivalsDto);
        else
        {
            return ResponseEntity.ok(arrivalsDto);
        }
    }
    @GetMapping("/arrival/{id}")
    public ResponseEntity<ArrivalCreateDto> getArrivalById(@PathVariable Long id)
    {
        ArrivalCreateDto data = arrivalService.find(id)
                    .map(t -> arrivalMapper.toCreateDto(t))
                    .orElseThrow(ArrivalNotFoundException::new);

        return ResponseEntity.status(HttpStatus.FOUND).body(data);
    }
    @PostMapping("/arrival")
    public ResponseEntity<ArrivalCreateDto> createArrival(@RequestBody ArrivalDto arrivalDto)
    {
       Arrival arrival = arrivalMapper.toEntity(arrivalDto);
       Arrival arrivalCreated = arrivalService.create(arrival);
       ArrivalCreateDto arrivalCreatedDto = arrivalMapper.toCreateDto(arrivalCreated);
       URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(arrivalCreated.getId()).toUri();
       return ResponseEntity.created(location).body(arrivalCreatedDto);
    }
    @PutMapping("/arrival/{id}")
    public ResponseEntity<ArrivalCreateDto> updateArrival(@PathVariable Long id, @RequestBody ArrivalDto arrivalDto)
    {
        arrivalService.find(id).orElseThrow(ArrivalNotFoundException::new);
        Arrival arrival = arrivalMapper.toEntity(arrivalDto);
        Optional<Arrival> arrivalUpdated = arrivalService.update(id,arrival);
        ArrivalCreateDto arrivalUpdatedDto = arrivalMapper.toCreateDto(arrivalUpdated);
        return ResponseEntity.status(HttpStatus.OK).body(arrivalUpdatedDto);
    }
    @DeleteMapping("/arrival/{id}")
    public ResponseEntity<Void> deleteArrival(@PathVariable Long id)
    {
        arrivalService.find(id).orElseThrow(ArrivalNotFoundException::new);
        arrivalService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
    
}
