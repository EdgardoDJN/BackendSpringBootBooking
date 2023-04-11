package web.programming.flight_booking_api.entidades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="flights")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private int ticketPrice;
    @Column(nullable = false)
    private String ticketCurrency;
    @Column(nullable = false)
    private int flightNumber;
    @Column(nullable = false)
    private int seatCapacity;
    @Column(nullable = false)
    private String airlineName;
    @Enumerated(EnumType.STRING)
    private FlightClass flightClass;

    @ManyToOne
    @JoinColumn(name = "departure_id")
    private Departure departure;

    @ManyToOne
    @JoinColumn(name = "arrival_id")
    private Arrival arrival;

    @OneToMany(mappedBy = "flight")
    private Set<Booking> bookings;

}
