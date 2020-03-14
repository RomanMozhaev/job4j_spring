package ru.job4j.first;

import org.springframework.stereotype.Component;

@Component
public class JDBCStorage implements StorageJDBC {
    @Override
    public String add(User user) {
        return "JDBC";
    }
}
