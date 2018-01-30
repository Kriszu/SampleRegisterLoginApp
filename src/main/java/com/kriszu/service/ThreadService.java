package com.kriszu.service;

import com.kriszu.model.Thread;

/**
 * Created by Kriszu on 24.10.2017.
 */

public interface ThreadService {

    void save(Thread thread, String username);
    Thread findByTitle(String title);
    void getSampleThreadByParsing();

}
