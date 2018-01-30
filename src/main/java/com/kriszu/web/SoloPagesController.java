package com.kriszu.web;

import com.kriszu.repository.ThreadRepository;
import com.kriszu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class SoloPagesController {

    @Autowired
    private ThreadRepository threadRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/thread/{id}", method = RequestMethod.GET)
    public String soloThreadPage(@PathVariable Long id, Model model, Authentication auth) {

        model.addAttribute("thread",threadRepository.getOne(id));
        return "threadid";
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public String soloUserPage(@PathVariable Long id, Model model) {

        model.addAttribute("user", userRepository.getOne(id));
        return "userid";
    }
}
