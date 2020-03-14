package ru.job4j.storages.persistent;

import ru.job4j.storages.models.User;

import java.util.List;

public class UserStorage {

    private final Storage storage;

    public UserStorage(final Storage storage) {
        this.storage = storage;
    }

    public int add(User user) {
        return this.storage.add(user);
    }

    public List<User> getAll() {
        return this.storage.getAll();
    }

    public  User findById(User user) {
        return this.storage.findById(user);
    }

    public int delete(User user) {
        return this.storage.delete(user);
    }
}
