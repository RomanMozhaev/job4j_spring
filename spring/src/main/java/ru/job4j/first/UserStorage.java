package ru.job4j.first;

public class UserStorage {

    private final Storage storage;

    public UserStorage(final Storage storage) {
        this.storage = storage;
    }

    public String add(User user) {
        return this.storage.add(user);
    }
}
