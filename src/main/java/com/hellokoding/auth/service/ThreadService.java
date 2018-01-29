package com.hellokoding.auth.service;

import com.hellokoding.auth.model.Thread;
import com.hellokoding.auth.model.User;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Kriszu on 24.10.2017.
 */

public interface ThreadService {

    void save(Thread thread, String username);
    Thread findByTitle(String title);

}
