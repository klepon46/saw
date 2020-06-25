package com.gstudio.saw.controller;

import com.gstudio.saw.model.Data;
import com.gstudio.saw.model.Nilai;
import com.gstudio.saw.model.Person;
import com.gstudio.saw.repository.DataRepository;
import com.gstudio.saw.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/list-data")
public class ListDataController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DataRepository dataRepository;

    @GetMapping("/menu")
    public String menu(Data data) {
        return "ListData/main";
    }

    @PostMapping("/addData")
    public String addData(@Valid Data data, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("status","error");
            return "ListData/main";
        }

        dataRepository.save(data);
        return "redirect:menu";
    }

}
