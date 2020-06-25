package com.gstudio.saw.controller;

import com.gstudio.saw.model.Bobot;
import com.gstudio.saw.model.Kriteria;
import com.gstudio.saw.repository.BobotRepository;
import com.gstudio.saw.repository.KriteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/bobot")
public class BobotController {

    @Autowired
    private BobotRepository bobotRepository;

    @Autowired
    private KriteriaRepository kriteriaRepository;

    @GetMapping("/menu")
    public String menu(Model model) {
        Optional<Bobot> bobot = bobotRepository.findById(1);
        model.addAttribute("bobot", bobot.get());
        return "bobot/main";
    }

    @PostMapping("/save")
    public String saveBobot(Bobot bobot) {
        bobot.setId(1);
        bobotRepository.save(bobot);
        return "redirect:menu";
    }

    @PostMapping("/saveKriteria")
    public String saveKriteria(Kriteria kriteria) {
        kriteria.setId(1);
        kriteriaRepository.save(kriteria);
        return "redirect:menu";
    }

    @RequestMapping(value = "/getKriteria", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    public Kriteria generateKriteriaLabel() {
        Optional<Kriteria> kriteria = kriteriaRepository.findById(1);
        return kriteria.get();
    }

}
