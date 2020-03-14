package ru.job4j.first;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("standard")
public class JDBCStorage implements StorageJDBC {
    @Override
    public String add(User user) {
        return "JDBC";
    }
}
