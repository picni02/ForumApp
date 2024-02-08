package com.example.web_250.controllers;

import com.example.web_250.services.CategoryService;
import com.example.web_250.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.web_250.models.entities.User;
import com.example.web_250.models.in.CategoryIn;
import com.example.web_250.models.in.UserIn;
import com.example.web_250.services.EventService;


@Controller
public class RoutingPagesController {

    @Autowired
    private EventService _EventService;

    @Autowired 
    private CategoryService _CategoryService;

    @Autowired
    private UserService _UserService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String registrationPage(Model model) {
        UserIn user = new UserIn();
        model.addAttribute("user", user);
        return "registration";
    }

    @GetMapping("/addcategory")
    public String addCategoryPage(Model model) {
        CategoryIn category = new CategoryIn();
        model.addAttribute("category", category);
        return "addcategory";
    }

    @GetMapping("/adminpanel")
    public String adminPanelPage(Model model) {
        model.addAttribute("events", _EventService.getAllEvents());
        model.addAttribute("categories", _CategoryService.getAllCategories());
        return "adminpanel";
    }

    @GetMapping("/profile")
    public String profilePage(Model model) {
        User temp = _UserService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName().toString());
        model.addAttribute("user", temp);
        return "profile";
    }
}
