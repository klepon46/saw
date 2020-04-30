package com.gstudio.saw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bobot")
public class BobotController {

    @GetMapping("/menu")
    public String menu() {
        return "/bobot/main";
    }

}
