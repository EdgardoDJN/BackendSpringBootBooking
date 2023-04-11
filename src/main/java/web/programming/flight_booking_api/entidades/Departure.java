package web.programming.flight_booking_api.entidades;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="departures")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Departure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private LocalDate departureDate;
    @Column(nullable = false)
    private String departureAirportCode;
    @Column(nullable = false)
    private String departureAirportName;
    @Column(nullable = false)
    private String departureCity;
    @Column(nullable = false)
    private String departureLocale;
    @OneToMany(mappedBy = "departure")
    private Set<Flight> flights;
}
