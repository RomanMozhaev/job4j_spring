package ru.job4j.first;

import org.junit.Test;
import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserStorageTest {

    /**
     * the sample from the video
     */
    @Test
    public void whenUserStorageGotUserThenAddedAndMessage() {
        Storage storage = new MemoryStorage();
        UserStorage userStorage = new UserStorage(storage);
        userStorage.add(new User());
    }

    /**
     * the test for beans described via spring-context.xml
     */
    @Test
    public void whenLoadContextThenGotStringMemory() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserStorage storage = context.getBean(UserStorage.class);
        assertEquals(storage.add(new User()), "Memory");
    }

    /**
     * the test for beans described with annotations.
     * Primary bean is injected.
     */
    @Test
    public void whenLoadContextThenGotStringPrimaryJDBC() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserStoragePrimaryJDBC storage = context.getBean(UserStoragePrimaryJDBC.class);
        assertEquals(storage.add(new User()), "PrimaryJDBC");
    }

    /**
     * the test for beans described with annotations.
     * Qualified "standard" bean is injected.
     */
    @Test
    public void whenLoadContextThenGotStringQualifiedJDBC() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserStorageJDBC storage = context.getBean(UserStorageJDBC.class);
        assertEquals(storage.add(new User()), "JDBC");
    }
}