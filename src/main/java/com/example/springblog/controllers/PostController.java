package com.example.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {


    @RequestMapping(path = "/posts/index", method = RequestMethod.GET)
    public String postsIndex(Model model){
        ArrayList<Post> posts = new ArrayList<>();
        Post post1 = new Post("title-1", "body-1");
        Post post2 = new Post("title-2", "body-2");
        posts.add(post1);
        posts.add(post2);
        model.addAttribute("posts", posts);
        return "/posts/index";
    }


    @GetMapping("/posts/show")
    public String showPost(Model model){
        Post onePost1 = new Post("A Post", "This is a post");
        model.addAttribute("onepost", onePost1);
        return "/posts/show";
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
