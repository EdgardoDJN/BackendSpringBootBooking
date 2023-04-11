package web.programming.flight_booking_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.programming.flight_booking_api.entidades.Arrival;
import web.programming.flight_booking_api.repositories.ArrivalRepository;

@Service
public class ArrivalServiceImpl implements ArrivalService {
    @Autowired
    private final ArrivalRepository arrivalRepository;
    
    public ArrivalServiceImpl(ArrivalRepository arrivalRepository) {
        this.arrivalRepository = arrivalRepository;
    }

    @Override
    public Arrival create(Arrival arrival) {
        Arrival copy = new Arrival(
            null,
            arrival.getArrivalDate(),
            arrival.getArrivalAirportCode(),
            arrival.getArrivalAirportName(),
            arrival.getArrivalCity(),
            arrival.getArrivalLocale(),
            null);
        return arrivalRepository.save(copy);
    }

    @Override
    public Optional<Arrival> update(Long id, Arrival arrival) {
        return arrivalRepository.findById(id).map(a -> {
            a.setArrivalDate(arrival.getArrivalDate());
            a.setArrivalAirportCode(arrival.getArrivalAirportCode());
            a.setArrivalAirportName(arrival.getArrivalAirportName());
            a.setArrivalCity(arrival.getArrivalCity());
            a.setArrivalLocale(arrival.getArrivalLocale());
            return arrivalRepository.save(a);
        });
    }

    @Override
    public List<Arrival> findAll() {
        return arrivalRepository.findAll();
    }

    @Override
    public Optional<Arrival> find(Long id) {
        return arrivalRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        arrivalRepository.deleteById(id);
    }
    
}
