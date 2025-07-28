package com.example.user_database.controllers;

import com.example.user_database.models.Entity;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EntityControllers {

    List<Entity> entityitems = new ArrayList<>();

    @GetMapping("/home")
    public String showHome(Model model){
        model.addAttribute("Entities",entityitems);
        return "index";
    }

    @PostMapping("/add")
    public String addEntity(@ModelAttribute @Valid Entity entity , BindingResult criteria, Model model){
        model.addAttribute("entity.id",entity.getId());
        model.addAttribute("entity.name",entity.getName());
        model.addAttribute("entity.email",entity.getEmail());
        if(criteria.hasErrors()){
            model.addAttribute("Entities",entityitems);
            return"index";
        }
        entityitems.add(entity);
        return "redirect:/home";
    }
}
