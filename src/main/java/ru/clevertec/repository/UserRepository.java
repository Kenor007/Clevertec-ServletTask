package ru.clevertec.repository;

import ru.clevertec.model.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    List<User> findAll();
}