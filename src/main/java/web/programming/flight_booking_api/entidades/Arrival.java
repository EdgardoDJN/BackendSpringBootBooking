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
@Table(name="arrivals")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Arrival {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private LocalDate arrivalDate;
    @Column(nullable = false)
    private String arrivalAirportCode;
    @Column(nullable = false)
    private String arrivalAirportName;
    @Column(nullable = false)
    private String arrivalCity;
    @Column(nullable = false)
    private String arrivalLocale;
    @OneToMany(mappedBy = "arrival")
    private Set<Flight> flights;
}
