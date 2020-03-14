package ru.job4j.storages.starting;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.job4j.storages.models.User;
import ru.job4j.storages.persistent.UserStorage;

import java.util.List;

public class ImportUser {

    public static void main(String[] args) {
        ImportUser importUser = new ImportUser();
        importUser.start();
    }

    public void start() {
        User user = new User("Alex", "Balduin");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserStorage storage = context.getBean(UserStorage.class);
        storage.add(user);
        List<User> list = storage.getAll();
        list.stream().forEach(u -> {
            System.out.println(u.getId());
            System.out.println(u.getName());
            System.out.println(u.getSurname());
            System.out.println();
        });
    }
}
