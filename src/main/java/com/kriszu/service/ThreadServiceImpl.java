package com.kriszu.service;

import com.kriszu.model.Thread;
import com.kriszu.repository.ThreadRepository;
import com.kriszu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



