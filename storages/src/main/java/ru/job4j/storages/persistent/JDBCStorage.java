package ru.job4j.storages.persistent;

import ru.job4j.storages.models.User;

import javax.persistence.*;
import java.util.List;

public class JDBCStorage implements Storage {

    /**
     * the Entity Manager Factory
     */
    private final EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("Storage");

    @Override
    public int add(User user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        int result = -1;
        try {
            tx.begin();
            em.persist(user);
            tx.commit();
            result = user.getId();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        return result;
    }

    @Override
    public List<User> getAll() {
        EntityManager em = this.emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<User> users = null;
        try {
            tx.begin();
            Query q = em.createQuery("select u From User u");
            users = q.getResultList();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        return users;
    }

    @Override
    public int delete(User user) {
        EntityManager em = this.emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        int result = -1;
        try {
            tx.begin();
            User dbUser = em.getReference(User.class, user.getId());
            em.remove(dbUser);
            em.flush();
            tx.commit();
            result = user.getId();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        return result;
    }

    @Override
    public User findById(User user) {
        EntityManager em = this.emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        User result = null;
        try {
            tx.begin();
            User dbUser = em.find(User.class, user.getId());
            tx.commit();
            result = dbUser;
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        return result;
    }
}
