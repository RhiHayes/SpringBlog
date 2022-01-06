package com.example.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfileController {

    @GetMapping("/profile/{username}")
    public String username (@PathVariable String username, Model model) {
        model.addAttribute("username", username);
        return "profile";
    }


}
