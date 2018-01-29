package com.hellokoding.auth.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Kriszu on 23.10.2017.
 */

@Controller
public class OnlineController {

    @Autowired
    private SessionRegistry sessionRegistry;

    public List<String> listOnlineUsers(){
        Collection<Object> principals = sessionRegistry.getAllPrincipals();
        List<String> usersNamesList = new ArrayList<String>();

        for (Object principal: principals) {
            if (principal instanceof User) {
                usersNamesList.add(((User) principal).getUsername());
            }
        }
        return usersNamesList;
    }


}
