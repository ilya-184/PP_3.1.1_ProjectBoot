package com.kata.boot.PP_31._ProjectBoot.dao;

import com.kata.boot.PP_31._ProjectBoot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("SELECT us from User us", User.class).getResultList();

    }

    @Override
    public void createUser(User user) {
        em.persist(user);
        em.flush();
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
        em.flush();
    }

    @Override
    public User readUser(long id) {
        return em.find(User.class, id);
    }

    @Override
    public User deleteUser(long id) {
        User user = readUser(id);
        if (user == null) {
            throw new NullPointerException("User not found");
        }
        em.remove(user);
        em.flush();
        return user;
    }
}
