package com.codeup.listology.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @GetMapping("/users")
    @ResponseBody
    public String viewUserIndex() {
        return "view users index";
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public String viewUser(@PathVariable long id) {
        return "view user profile";
    }

    @GetMapping("/users/create")
    @ResponseBody
    public String viewCreateUser() {
        return "view user creation form";
    }

    @PostMapping("/users/create")
    @ResponseBody
    public String submitUser() {
        return "submit user creation form";
    }




}
