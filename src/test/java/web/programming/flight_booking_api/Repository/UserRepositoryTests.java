package web.programming.flight_booking_api.Repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import web.programming.flight_booking_api.entities.User;
import web.programming.flight_booking_api.repositories.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;
       


    public UserRepositoryTests() {
    }

    @Test
    public void crearUsuario() {
        User user = new User();
        user.setId(null);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setUserName("cc");
        user.setPassword("11");
        String dateOString = "1999-01-01";
        LocalDate date = LocalDate.parse(dateOString);
        user.setDateofbirth(date);
        user.setPhoneNumber(1234);
        user.setBookings(null);
        

        User userGuardado = userRepository.save(user);
        System.out.println("userGuardado = " + userGuardado);
        assertNotNull(userGuardado);
    }
}
        
