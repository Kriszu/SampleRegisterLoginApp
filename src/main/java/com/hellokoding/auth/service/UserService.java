package com.hellokoding.auth.service;

import com.hellokoding.auth.model.Thread;
import com.hellokoding.auth.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;


public interface UserService {
    void save(User user);

    User findByUsername(String username);

}
