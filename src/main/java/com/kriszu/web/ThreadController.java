package com.kriszu.web;

import com.kriszu.model.Thread;
import com.kriszu.repository.ThreadRepository;
import com.kriszu.service.ThreadService;
import com.kriszu.validator.ThreadValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.security.Principal;
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
    public String home(Model model) throws IOException{
        List<Thread> threads = threadRepository.findAll(sortById());
        model.addAttribute("threadList", threads);
        return "home";
    }

}
