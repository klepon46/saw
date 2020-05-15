package com.gstudio.saw.controller;

import com.gstudio.saw.model.Data;
import com.gstudio.saw.model.Nilai;
import com.gstudio.saw.model.Person;
import com.gstudio.saw.repository.DataRepository;
import com.gstudio.saw.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/list-data")
public class ListDataController {

    @Autowired
    private PersonRepository personRepository;
    
    @Autowired
    private DataRepository dataRepository;

    @GetMapping("/menu")
    public String menu() {
        return "/ListData/main";
    }

    @PostMapping("/addData")
    public String addData(@ModelAttribute Data data) {
        dataRepository.save(data);
        return "redirect:/list-data/menu";
    }




}
