package com.gstudio.saw.controller;

import com.gstudio.saw.model.User;
import com.gstudio.saw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/profile")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/index")
    public String index(User user) {
        return "profile/index";
    }

    @PostMapping("/save")
    public String save(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "profile/index";
        }
        try {
            String encrypted = new BCryptPasswordEncoder().encode(user.getPassword());
            user.setPassword(encrypted);
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            result.rejectValue("username", "username.exists", "Username sudah ada");
            return "profile/index";
        }

        return "redirect:index";
    }


}
