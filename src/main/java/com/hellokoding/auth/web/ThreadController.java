package com.hellokoding.auth.web;

import com.hellokoding.auth.model.Thread;
import com.hellokoding.auth.model.User;
import com.hellokoding.auth.repository.ThreadRepository;
import com.hellokoding.auth.service.ThreadService;
import com.hellokoding.auth.validator.ThreadValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Kriszu on 24.10.2017.
 */
@Controller
public class ThreadController {

    @Autowired
    private ThreadService threadService;

    @Autowired
    private ThreadValidator threadValidator;

    @Autowired
    private ThreadRepository threadRepository;


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String AddThreadPage(Model model){

        model.addAttribute("threadForm",new Thread());

        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBtn(@ModelAttribute("threadForm") Thread threadForm, Model model, BindingResult bindingResult
    , Principal principal){


        threadValidator.validate(threadForm,bindingResult);

        if(bindingResult.hasErrors()){
            return "/add";
        }
        threadService.save(threadForm,principal.getName());
        return "redirect:/home";
    }

    private Sort sortById(){
        return new Sort(Sort.Direction.ASC, "id");
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model){
        List<Thread> threads = threadRepository.findAll(sortById());
        model.addAttribute("threadList", threads);
        return "home";
    }

}
