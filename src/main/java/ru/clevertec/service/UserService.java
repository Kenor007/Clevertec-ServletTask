package ru.clevertec.service;

import ru.clevertec.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto saveUser(UserDto userDto);

    List<UserDto> findAllUsers();
}