package com.example.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")

    @ResponseBody
    public String home() {
        return "WELCOME TO THE LANDING PAGE!";
    }

    @GetMapping("/index")

    public String welcome() {
        return "home";
    } //Returning name of html file, DO NOT USE RESPONSE BODY TO GRAB IT, that is for strings only.



}
