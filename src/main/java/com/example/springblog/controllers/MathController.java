package com.example.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @RequestMapping(path = "add{number}and{number2}", method = RequestMethod.GET)
    @ResponseBody

    public String add(@PathVariable int number, @PathVariable int number2) {
        return "Adding for a total of: " + (number + number2) + ".";
    }


    @RequestMapping(path = "subtract{number}from{number2}", method = RequestMethod.GET)
    @ResponseBody

    public String subtract(@PathVariable int number, @PathVariable int number2) {
        return "Subtracting for a total of: " + (number - number2) + ".";
    }


    @RequestMapping(path = "multiply{number}and{number2}", method = RequestMethod.GET)
    @ResponseBody

    public String multiply(@PathVariable int number, @PathVariable int number2) {
        return "Multiplying for a total of: " + (number * number2) + ".";
    }


    @RequestMapping(path = "divide{number}by{number2}", method = RequestMethod.GET)
    @ResponseBody

    public String divide(@PathVariable int number, @PathVariable int number2) {
        return "Dividing for a total of: " + (number / number2) + ".";
    }

}
