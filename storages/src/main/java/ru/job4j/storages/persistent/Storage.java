package ru.job4j.storages.persistent;

import ru.job4j.storages.models.User;

import java.util.List;

public interface Storage {

    int add(User user);

    List<User> getAll();

    int delete(User user);

    User findById(User user);

}
