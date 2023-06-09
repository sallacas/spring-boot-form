package com.springboot.form.app.controllers;

import com.springboot.form.app.models.domain.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@SessionAttributes("user")
public class FormController {
    @GetMapping("/form")
    public String form(Model model) {
        User user = new User();
        user.setName("Miguelito");
        user.setLastname("Mahuron");
        user.setId("11231-K");
        model.addAttribute("title","Post form using springboot");
        model.addAttribute("user",user);
        return "form";
    }
    @PostMapping("/form")
    public String processModel(@Valid User user, BindingResult rs, Model model, SessionStatus status) {
        model.addAttribute("title", "Result of post form");
        if (rs.hasErrors()){
            return "form";
        }
        model.addAttribute("user",user);
        status.setComplete();
        return "result";
    }
}
