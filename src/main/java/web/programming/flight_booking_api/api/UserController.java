package web.programming.flight_booking_api.api;

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

import web.programming.flight_booking_api.api.dto.UserCreateDto;
import web.programming.flight_booking_api.api.dto.UserDto;
import web.programming.flight_booking_api.api.dto.UserMapper;
import web.programming.flight_booking_api.entidades.User;
import web.programming.flight_booking_api.exceptions.UserNotFoundException;
import web.programming.flight_booking_api.services.UserService;

@RestController
@RequestMapping("/api/model")
public class UserController {
    @Autowired
    private final UserService userService;
    @Autowired
    private final UserMapper userMapper;
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }
    @GetMapping("/user")
    public ResponseEntity<List<UserCreateDto>> getAllUsers()
    {
        List<User> users = userService.findAll();
        List<UserCreateDto> usersDto = users.stream().map(userMapper::toCreateDto).collect(Collectors.toList());
        if(usersDto.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(usersDto);
        else
        {
            return ResponseEntity.ok(usersDto);
        }
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<UserCreateDto> getUserById(@PathVariable Long id)
    {
            UserCreateDto data = userService.find(id)
                        .map(t -> userMapper.toCreateDto(t))
                        .orElseThrow(UserNotFoundException::new);
    
            return ResponseEntity.status(HttpStatus.FOUND).body(data);
    }
    @PostMapping("/user")
    public ResponseEntity<UserCreateDto> createUser(@RequestBody UserDto userDto)
    {
        User user = userMapper.toEntity(userDto);
        User userCreated = userService.create(user);
        UserCreateDto userCreatedDto = userMapper.toCreateDto(userCreated);
        if(userCreatedDto.equals(null))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userCreatedDto);
        else
            return ResponseEntity.status(HttpStatus.CREATED).body(userCreatedDto);
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<UserCreateDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto)
    {
        userService.find(id).orElseThrow(UserNotFoundException::new);
        User user = userMapper.toEntity(userDto);
        Optional<User> userUpdated = userService.update(id, user);
        UserCreateDto userUpdatedDto = userMapper.toCreateDto(userUpdated);
        return ResponseEntity.status(HttpStatus.OK).body(userUpdatedDto);
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<UserCreateDto> deleteUser(@PathVariable Long id)
    {
        userService.find(id).orElseThrow(UserNotFoundException::new);
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
