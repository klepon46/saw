package com.gstudio.saw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list-data")
public class ListDataController {

    @GetMapping("/menu")
    public String menu(){

        return "/ListData/main";
    }


}
