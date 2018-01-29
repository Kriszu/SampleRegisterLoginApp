package com.hellokoding.auth.service;

import com.hellokoding.auth.model.Thread;
import com.hellokoding.auth.model.User;
import com.hellokoding.auth.repository.ThreadRepository;
import com.hellokoding.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.Set;

/**
 * Created by Kriszu on 24.10.2017.
 */
@Service
public class ThreadServiceImpl implements ThreadService {

    @Autowired
    private ThreadRepository threadRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public void save(Thread thread, String username) {

        thread.setTitle(thread.getTitle());
        thread.setContent(thread.getContent());
        thread.setUser(userRepository.findByUsername(username));
        threadRepository.save(thread);
    }

    @Override
    public Thread findByTitle(String title) {

        return null;
    }


}



