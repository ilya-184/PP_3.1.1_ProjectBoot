package com.kata.boot.PP_31._ProjectBoot.dao;

import com.kata.boot.PP_31._ProjectBoot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void createUser(User user);

    void updateUser(User user);

    User readUser(long id);

    User deleteUser(long id);
}
