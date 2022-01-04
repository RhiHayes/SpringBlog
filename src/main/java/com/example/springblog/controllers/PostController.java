package com.example.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    private final PostRepository postDao; //injection

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts/index") //Populates Page
    public String postsIndex(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "/posts/index";
    }


    @GetMapping("/posts/{postId}") //Redirect to show when view post button is clicked
    public String viewPost(Model model, @PathVariable Long postId) {
        Post showPost = postDao.getById(postId);
        model.addAttribute("post", showPost);
        return "/posts/show";
    }

    @GetMapping("/edit/{postId}") //Shows which post you're editing
    public String editPostForm(Model model, @PathVariable Long postId) {
        Post post = postDao.getById(postId);
        model.addAttribute("posts", post); //this pre-populates the info in the form in the edit.html

        return "/posts/edit";
    }

    @PostMapping("/edit/{postId}") //Saves new information and redirects you back to index when done
    public String editPost(@PathVariable("postId") Long postId, @ModelAttribute Post post) {

        postDao.save(post);

        return "redirect:/posts/index";
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

    @PostMapping("/posts/index") //Deletes Post
    public void deletePost(Long postId) {
        postDao.deleteById(postId);
    }

}
