package ru.job4j.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserStoragePrimaryJDBC {

    private final StorageJDBC storage;

    @Autowired
    public UserStoragePrimaryJDBC(final StorageJDBC storage) {
        this.storage = storage;
    }

    public String add(User user) {
        return this.storage.add(user);
    }
}
