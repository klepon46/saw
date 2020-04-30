package com.gstudio.saw.controller;

import com.gstudio.saw.model.Person;
import com.gstudio.saw.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ListDataRest")
public class ListDataRestController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/getAllPerson")
    public List<Person> getAllPerson(){
        return (List<Person>) personRepository.findAll();
    }
}
