package web.programming.flight_booking_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.programming.flight_booking_api.entities.Departure;
import web.programming.flight_booking_api.repositories.DepartureRepository;

@Service
public class DepartureServiceImpl implements DepartureService {
    @Autowired
    private final DepartureRepository departureRepository;

    public DepartureServiceImpl(DepartureRepository departureRepository) {
        this.departureRepository = departureRepository;
    }

    @Override
    public Departure create(Departure departure) {
        Departure copy = new Departure(
            null,
            departure.getDepartureDate(),
            departure.getDepartureAirportCode(),
            departure.getDepartureAirportName(),
            departure.getDepartureCity(),
            departure.getDepartureLocale(),
            departure.getDepartureTime(),
            null);
        return departureRepository.save(copy);
    }

    @Override
    public Optional<Departure> update(Long id, Departure departure) {
        return departureRepository.findById(id).map(d -> {
            d.setDepartureDate(departure.getDepartureDate());
            d.setDepartureAirportCode(departure.getDepartureAirportCode());
            d.setDepartureAirportName(departure.getDepartureAirportName());
            d.setDepartureCity(departure.getDepartureCity());
            d.setDepartureLocale(departure.getDepartureLocale());
            return departureRepository.save(d);
        });
    }

    @Override
    public List<Departure> findAll() {
        return departureRepository.findAll();
    }

    @Override
    public Optional<Departure> find(Long id) {
        return departureRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        departureRepository.deleteById(id);
    }
    
}
