package web.programming.flight_booking_api.services;

import java.util.List;
import java.util.Optional;

import web.programming.flight_booking_api.entidades.User;

public interface UserService {
    User create(User user);
    Optional<User> update(Long id, User user);
    List<User> findAll();
    Optional<User> find(Long id);
    void delete(Long id);
}
