package ru.clevertec.mapper;

import org.mapstruct.Mapper;
import ru.clevertec.dto.UserDto;
import ru.clevertec.model.User;

@Mapper
public interface UserMapper {
    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);
}