package com.example.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    private final PostRepository postDao; //injection
    private final UserRepository userDao; //injection
    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;

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
        model.addAttribute("user", showPost.getUser());
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
    public String viewCreatePost(Model model){
        model.addAttribute("posts", new Post());
        return "/posts/create";
    }


    @PostMapping("/posts/create")
    public String addNewPost(@ModelAttribute Post post) {

        User user = userDao.getById(1L); //Manually Setting User

        post.setUser(user);

        postDao.save(post);

        String emailBody = "Your post was posted: " + post.getBody();

        emailService.prepareAndSend(post, post.getTitle(), emailBody);
        return "redirect:/posts/index";
    }

    @PostMapping("/posts/index") //Deletes Post
    public void deletePost(Long postId) {
        postDao.deleteById(postId);
    }

}
