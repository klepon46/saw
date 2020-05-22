package com.gstudio.saw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/periode")
public class PeriodeController {


    @GetMapping("/index")
    public String index(){
        return "/periode/periode-index";
    }

    @GetMapping("/report")
    public String report(@RequestParam("kuartal") int kuartal, @RequestParam("year")int year){

        return "/periode/report";
    }

}
