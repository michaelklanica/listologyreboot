package com.codeup.listology.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @GetMapping("/users")
    public String viewUserIndex() {
        return "users/index";
    }

    @GetMapping("/users/{id}")
    public String viewUser(@PathVariable long id, Model model) {
        return "users/user";
    }

    @GetMapping("/users/create")
    public String viewCreateUser() {
        return "users/create";
    }

    @PostMapping("/users/create")
    @ResponseBody
    public String submitUser() {
        return "submit user creation form";
    }




}
