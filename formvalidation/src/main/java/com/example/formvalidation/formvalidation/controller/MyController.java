package com.example.formvalidation.formvalidation.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.formvalidation.formvalidation.entities.LoginData;

@Controller
public class MyController {
    
    @GetMapping("/form")
    public String openForm(Model model) {
        model.addAttribute("loginData", new LoginData());
        return "form";
    }

    //handler for process form
    @PostMapping("/process")
    public String processForm(@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult result) {
        System.out.println(loginData);
        System.out.println(result);

        if(result.hasErrors()) {
            return "success";
        }
        return "success";
    }
    
}
