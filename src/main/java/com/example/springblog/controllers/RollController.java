package com.example.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class RollController {

        @GetMapping("/roll")
        public String showDicePage() {
            return "roll";
        }

    @GetMapping("/roll/{userGuess}")
    public String userGuess(@PathVariable int userGuess, Model model) {
        Random random = new Random();
        int randomNumber = random.nextInt(6) + 1;
        model.addAttribute("userGuess", "You selected " + userGuess);
        model.addAttribute("randomNumber", "The random number is " + randomNumber);


        if(userGuess == randomNumber){
            model.addAttribute("message", "You guessed correctly!");
        } else {
            model.addAttribute("message", "You got it wrong!");
        }

        return "roll";

    }

}


