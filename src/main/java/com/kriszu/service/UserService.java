package com.kriszu.service;

import com.kriszu.model.User;


public interface UserService {
    void save(User user);

    User findByUsername(String username);

}
