package com.codegym.file.service;

import com.codegym.file.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void save(User user);
}
