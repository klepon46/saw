package com.gstudio.saw.controller;

import com.gstudio.saw.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {
//        model.addAttribute("user", new User());
//        model.addAttribute("str", "From Controller");
//        return "index";
        return "welcome";
    }

    @GetMapping("/header")
    public String header(){
        return "header";
    }

    @PostMapping(value = "/save")
    public ModelAndView save(@ModelAttribute User user, BindingResult result ) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-data");
        modelAndView.addObject(user);
        return modelAndView;
    }
}
