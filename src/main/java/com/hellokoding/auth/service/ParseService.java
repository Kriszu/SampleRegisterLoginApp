
package com.hellokoding.auth.service;

import org.springframework.stereotype.Service;


import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by Kriszu on 29.10.2017.
 */

@Service
public interface ParseService {

    void saveThreadsFromWp() throws IOException;
}

