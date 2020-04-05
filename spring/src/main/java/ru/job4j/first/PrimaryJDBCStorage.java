package ru.job4j.first;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Qualifier("primary")
public class PrimaryJDBCStorage implements StorageJDBC {
    @Override
    public String add(User user) {
        return "PrimaryJDBC";
    }
}
