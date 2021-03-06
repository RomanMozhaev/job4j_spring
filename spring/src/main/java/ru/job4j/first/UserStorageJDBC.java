package ru.job4j.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserStorageJDBC {

    private final StorageJDBC storage;

    @Autowired
    public UserStorageJDBC(@Qualifier("standard") final StorageJDBC storage) {
        this.storage = storage;
    }

    public String add(User user) {
        return this.storage.add(user);
    }
}
