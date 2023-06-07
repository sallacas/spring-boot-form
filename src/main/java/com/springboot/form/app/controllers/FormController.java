package com.springboot.form.app.controllers;

import com.springboot.form.app.models.domain.User;
import com.springboot.form.app.models.domain.Users;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.exceptions.TemplateInputException;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FormController {
    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("title","Post form using springboot");
        return "form";
    }
    //@PostMapping("/form")
    public String process(Model model, @RequestParam String username, @RequestParam String password, @RequestParam String email) {
        Users users = new Users(username,password,email);
        model.addAttribute("title", "Result of post form");
        model.addAttribute("user",users);
        return "result";
    }
    @PostMapping("/form")
    public String processModel(@Valid Users user, BindingResult rs, Model model) {
        model.addAttribute("title", "Result of post form");
        if (rs.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            rs.getFieldErrors().forEach(error -> errors.put(error.getField(), "Error in field ".concat(error.getDefaultMessage())));
            model.addAttribute("error",errors);
            return "form";
        }
        model.addAttribute("user",user);
        return "result";
    }
}
