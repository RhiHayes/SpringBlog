package com.example.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/posts")

    @ResponseBody
    public String hello() {
        return "This is the posts index!";
    }


    @RequestMapping(path = "posts/{id}", method = RequestMethod.GET)

    @ResponseBody

    public String id(@PathVariable int id) {
        return "This is post number " + id + ".";
    }


    @GetMapping("/posts/create")

    @ResponseBody
    public String create() {
        return "This is the form for creating the post!";
    }


    @RequestMapping(path = "posts/create", method = RequestMethod.POST)

    @ResponseBody
    public String createPost() {
        return "Create a new post here!";
    }

}
