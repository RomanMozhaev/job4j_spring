package ru.job4j.first;

public class MemoryStorage implements Storage {

    @Override
    public String add(User user) {
        return "Memory";
    }
}
