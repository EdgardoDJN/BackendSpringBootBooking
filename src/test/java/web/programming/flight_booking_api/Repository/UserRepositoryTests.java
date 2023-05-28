package web.programming.flight_booking_api.Repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import web.programming.flight_booking_api.entities.User;
import web.programming.flight_booking_api.repositories.UserRepository;

@DataJpaTest //Solo se le hace prueba a la entidad y a los repositorios
public class UserRepositoryTests {
    /* 
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void should_find_no_users_if_repository_is_empty() {
        Iterable<User> users = userRepository.findAll();
        assertThat(users).isEmpty();
    }
    @Test
    public void should_store_a_user() {
        User user = new User(
                null,
                "John",
                "Doe",
                "johndoe",
                "mypassword",
                LocalDate.of(1990, 8, 15),
                1234567890,
                null);
        User user2 = userRepository.save(user);
        assertThat(user2).hasFieldOrPropertyWithValue("firstName", "John");
        assertThat(user2).hasFieldOrPropertyWithValue("lastName", "Doe");
        assertThat(user2).hasFieldOrPropertyWithValue("userName", "johndoe");
        assertThat(user2).hasFieldOrPropertyWithValue("password", "mypassword");
        assertThat(user2).hasFieldOrPropertyWithValue("dateofbirth", LocalDate.of(1990, 8, 15));
        assertThat(user2).hasFieldOrPropertyWithValue("phoneNumber", 1234567890);
    }
    @Test
    public void should_find_all_tutorials() {
        User user1 = new User(
                null,
                "John",
                "Doe",
                "johndoe",
                "mypassword",
                LocalDate.of(1990, 8, 15),
                1234567890,
                null);
        entityManager.persist(user1);
        User user2 = new User(
                null,
                "Jane",
                "Doe",
                "janedoe",
                "mypassword",
                LocalDate.of(1990, 8, 15),
                1234567890,
                null);
        entityManager.persist(user2);
        User user3 = new User(
                null,
                "John",
                "Smith",
                "johnsmith",
                "mypassword",
                LocalDate.of(1990, 8, 15),
                1234567890,
                null);
        entityManager.persist(user3);
        Iterable<User> users = userRepository.findAll();
        assertThat(users).hasSize(3).contains(user1, user2, user3);
    }
    @Test
    public void should_find_tutorial_by_id(){
        User user1 = new User(
                null,
                "John",
                "Doe",
                "johndoe",
                "mypassword",
                LocalDate.of(1990, 8, 15),
                1234567890,
                null);
        entityManager.persist(user1);
        User user2 = new User(
                null,
                "Jane",
                "Doe",
                "janedoe",
                "mypassword",
                LocalDate.of(1990, 8, 15),
                1234567890,
                null);
        entityManager.persist(user2);
        User foundUser = userRepository.findById(user2.getId()).get();
        assertThat(foundUser).isEqualTo(user2);
    }
    @Test
    public void should_update_tutorial_by_id(){
        User user1 = new User(
                null,
                "John",
                "Doe",
                "johndoe",
                "mypassword",
                LocalDate.of(1990, 8, 15),
                1234567890,
                null);
        entityManager.persist(user1);
        User user2 = new User(
                null,
                "Jane",
                "Doe",
                "janedoe",
                "mypassword",
                LocalDate.of(1990, 8, 15),
                1234567890,
                null);
        entityManager.persist(user2);
        User updatedUser = new User(
                null,
                "Janess",
                "Does",
                "janedoes",
                "mypasswords",
                LocalDate.of(1991, 8, 15),
                1234567891,
                null);
        User user = userRepository.findById(user2.getId()).get();
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setUserName(updatedUser.getUserName());
        user.setPassword(updatedUser.getPassword());
        user.setDateofbirth(updatedUser.getDateofbirth());
        user.setPhoneNumber(updatedUser.getPhoneNumber());
        user.setBookings(updatedUser.getBookings());
        userRepository.save(user);
        User checkUser = userRepository.findById(user2.getId()).get();
        assertThat(checkUser.getId()).isEqualTo(user2.getId());
        assertThat(checkUser.getFirstName()).isEqualTo(updatedUser.getFirstName());
        assertThat(checkUser.getLastName()).isEqualTo(updatedUser.getLastName());
        assertThat(checkUser.getUserName()).isEqualTo(updatedUser.getUserName());
        assertThat(checkUser.getPassword()).isEqualTo(updatedUser.getPassword());
        assertThat(checkUser.getDateofbirth()).isEqualTo(updatedUser.getDateofbirth());
        assertThat(checkUser.getPhoneNumber()).isEqualTo(updatedUser.getPhoneNumber());
        assertThat(checkUser.getBookings()).isEqualTo(updatedUser.getBookings());
    }
    @Test
    public void should_delete_tutorial_by_id(){
        User user1 = new User(
                null,
                "John",
                "Doe",
                "johndoe",
                "mypassword",
                LocalDate.of(1990, 8, 15),
                1234567890,
                null);
        entityManager.persist(user1);
        User user2 = new User(
                null,
                "Jane",
                "Doe",
                "janedoe",
                "mypassword",
                LocalDate.of(1990, 8, 15),
                1234567890,
                null);
        entityManager.persist(user2);
        User user3 = new User(
                null,
                "John",
                "Smith",
                "johnsmith",
                "mypassword",
                LocalDate.of(1990, 8, 15),
                1234567890,
                null);
        entityManager.persist(user3);
        userRepository.deleteById(user2.getId());
        Iterable<User> users = userRepository.findAll();
        assertThat(users).hasSize(2).contains(user1, user3);
    }
    */
}
        
