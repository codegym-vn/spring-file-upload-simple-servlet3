package com.codegym.file.repository;

import com.codegym.file.model.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    void save(User user);
}
