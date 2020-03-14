package ru.job4j.storages.persistent;

import ru.job4j.storages.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryStorage implements Storage {

    private final Map<Integer, User> memory = new HashMap<>();
    private int userId = 0;

    @Override
    public int add(User user) {
        this.userId++;
        user.setId(this.userId);
        this.memory.put(user.getId(), user);
        return user.getId();
    }

    public List<User> getAll() {
        return new ArrayList<>(this.memory.values());
    }

    @Override
    public int delete(User user) {
        int result = -1;
        User deletedUser = this.memory.remove(user.getId());
        if (deletedUser != null) {
            result = deletedUser.getId();
        }
        return result;
    }

    @Override
    public User findById(User user) {
        return this.memory.get(user.getId());
    }
}
