package com.codeup.listology.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String viewPostIndex() {
        return "view post index";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String viewPost(@PathVariable long id){
        return "view post #" + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewCreatePost() {
        return "view post creation form";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String submitNewPost() {
        return "submit post creation form";
    }

}
