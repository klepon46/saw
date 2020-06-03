package com.gstudio.saw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class LoginController {

    @GetMapping("/login")
    public ModelAndView login(@RequestParam Optional<String> error){
        return new ModelAndView("login", "error", error);
    }

}
