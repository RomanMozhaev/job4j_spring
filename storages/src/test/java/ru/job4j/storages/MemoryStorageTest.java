package ru.job4j.storages;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.job4j.storages.models.User;
import ru.job4j.storages.persistent.MemoryStorage;
import ru.job4j.storages.persistent.Storage;
import ru.job4j.storages.persistent.UserStorage;

import java.util.List;

import static org.junit.Assert.*;

public class MemoryStorageTest {

    /**
     * the test for add and findById methods.
     */
    @Test
    public void whenAddThenFound() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserStorage storage = context.getBean(UserStorage.class);
        User user = new User("Miguel", "Sanders");
        int userId = storage.add(user);
        User userForSearching = new User();
        userForSearching.setId(userId);
        User foundUser = storage.findById(userForSearching);
        assertEquals(foundUser, user);
    }

    /**
     * the test for getAll method.
     */
    @Test
    public void whenAddedTwoThenListWithThem() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserStorage storage = context.getBean(UserStorage.class);
        User user1 = new User("Miguel", "Sanders");
        User user2 = new User("Angelica", "Holmes");
        storage.add(user1);
        storage.add(user2);
        List<User> users = storage.getAll();
        assertEquals(users, List.of(user1, user2));
    }

    /**
     * the test for delete method.
     */
    @Test
    public void whenAddedTwoAndOneDeletedThenListWithOnlyOne() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserStorage storage = context.getBean(UserStorage.class);
        User user1 = new User("Miguel", "Sanders");
        User user2 = new User("Angelica", "Holmes");
        storage.add(user1);
        int user2Id = storage.add(user2);
        List<User> usersBefore = storage.getAll();
        User userForDeleting = new User();
        userForDeleting.setId(user2Id);
        storage.delete(userForDeleting);
        List<User> usersAfter = storage.getAll();
        assertEquals(usersBefore, List.of(user1, user2));
        assertEquals(usersAfter, List.of(user1));
    }
}