package ru.clevertec.repository;

import ru.clevertec.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserrepositoryImpl implements UserRepository {
    private List<User> users = new ArrayList<>();

    public UserrepositoryImpl() {
        users.add(new User(1L, "Nik Nikantov"));
        users.add(new User(2L, "Vasiliy Smirnov"));
        users.add(new User(3L, "Olga Smirnova"));
    }

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}