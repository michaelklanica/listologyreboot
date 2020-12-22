package com.codeup.listology.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String viewPostIndex() {
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        return "posts/post";
    }

    @GetMapping("/posts/create")
    public String viewCreatePost() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String submitNewPost() {
        return "submit post creation form";
    }

}
