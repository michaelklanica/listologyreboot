package com.codeup.listology.controllers;

import com.codeup.listology.models.Post;
import com.codeup.listology.models.User;
import com.codeup.listology.repos.PostRepository;
import com.codeup.listology.repos.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;


    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

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
    public String viewCreatePost(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String submitNewPost(@ModelAttribute Post postToBeSaved) {
        User userDb = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postToBeSaved.setAuthor(userDb);
        Post dbPost = postDao.save(postToBeSaved);
        return "redirect:/posts/" + dbPost.getId() ;
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(Post postToBeSaved) {
        User userDb = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postToBeSaved.setAuthor(userDb);
        postDao.save(postToBeSaved);
        return "redirect:/posts";
    }




}
