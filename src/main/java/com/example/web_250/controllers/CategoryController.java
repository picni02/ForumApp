package com.example.web_250.controllers;

import java.util.List;

import com.example.web_250.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.web_250.models.in.CategoryIn;
import com.example.web_250.models.out.CategoryOut;

@Controller
public class CategoryController {
    
    @Autowired 
    private CategoryService _CategoryService;

    @GetMapping("/getcategories")
    public List<CategoryOut> getAllCategories() {
        return _CategoryService.getAllCategories();
    }


    @PostMapping("/addcategory")
    public String addNewCategory(@ModelAttribute("category") CategoryIn category, RedirectAttributes message) {
        _CategoryService.addNewCategory(category);
        message.addFlashAttribute("message", "Kategorija uspješno dodana.");
        return "redirect:adminpanel";
    }

    @PostMapping("/editcategory")
    public String editCategory(@ModelAttribute("categoryforedit") CategoryIn category, RedirectAttributes message) {
        _CategoryService.editCategory(category);
        message.addFlashAttribute("message", "Kategorija uspješno uređena.");
        return "redirect:/adminpanel";
    }
}
