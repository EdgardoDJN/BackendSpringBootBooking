package web.programming.flight_booking_api.api.dto;

import java.util.Optional;

import org.springframework.stereotype.Component;

import web.programming.flight_booking_api.entities.User;

@Component
public class UserMapper {
    //Pasar de una forma a otra forma
    /*public UserDto toDto(User user)
    {
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setUserName(user.getUserName());
        userDto.setPassword(user.getPassword());
        userDto.setDateofbirth(user.getDateofbirth());
        userDto.setPhoneNumber(user.getPhoneNumber());
        return userDto;
    }
    public User toEntity(UserDto userDto)
    {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setDateofbirth(userDto.getDateofbirth());
        user.setPhoneNumber(userDto.getPhoneNumber());
        return user;
    }
    public UserCreateDto toCreateDto(User user)
    {
        UserCreateDto userCreateDto = new UserCreateDto();
        userCreateDto.setId(user.getId());
        userCreateDto.setFirstName(user.getFirstName());
        userCreateDto.setLastName(user.getLastName());
        userCreateDto.setUserName(user.getUserName());
        userCreateDto.setPassword(user.getPassword());
        userCreateDto.setDateofbirth(user.getDateofbirth());
        userCreateDto.setPhoneNumber(user.getPhoneNumber());
        return userCreateDto;
    }
    public UserDto toDto(Optional<User> user)
    {
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.get().getFirstName());
        userDto.setLastName(user.get().getLastName());
        userDto.setUserName(user.get().getUserName());
        userDto.setPassword(user.get().getPassword());
        userDto.setDateofbirth(user.get().getDateofbirth());
        userDto.setPhoneNumber(user.get().getPhoneNumber());
        return userDto;
    }
    public UserCreateDto toCreateDto(Optional<User> user)
    {
        UserCreateDto userCreateDto = new UserCreateDto();
        userCreateDto.setId(user.get().getId());
        userCreateDto.setFirstName(user.get().getFirstName());
        userCreateDto.setLastName(user.get().getLastName());
        userCreateDto.setUserName(user.get().getUserName());
        userCreateDto.setPassword(user.get().getPassword());
        userCreateDto.setDateofbirth(user.get().getDateofbirth());
        userCreateDto.setPhoneNumber(user.get().getPhoneNumber());
        return userCreateDto;
    }
    //Faltan los dos de UserBookingDto
    */
    
}
