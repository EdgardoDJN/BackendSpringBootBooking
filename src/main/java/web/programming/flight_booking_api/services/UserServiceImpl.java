package web.programming.flight_booking_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.programming.flight_booking_api.entidades.User;
import web.programming.flight_booking_api.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;
    
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        User copy = new User(
            null,
            user.getFirstName(),
            user.getLastName(),
            user.getUserName(),
            user.getPassword(),
            user.getDateofbirth(),
            user.getPhoneNumber(),
            null);
        return userRepository.save(copy);
    }

    @Override
    public Optional<User> update(Long id, User user) {
        return userRepository.findById(id).map(u -> {
            u.setFirstName(user.getFirstName());
            u.setLastName(user.getLastName());
            u.setUserName(user.getUserName());
            u.setPassword(user.getPassword());
            u.setDateofbirth(user.getDateofbirth());
            u.setPhoneNumber(user.getPhoneNumber());
            return userRepository.save(u);
        });
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> find(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
    
}
