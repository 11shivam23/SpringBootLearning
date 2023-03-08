package com.example.thymeleaf.thymeleaf.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
    
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(Model model) {
        System.out.println("Inside about handler");
        model.addAttribute("name", "Shivam Vashishtha");
        model.addAttribute("currentDate", new Date().toLocaleString());
        return "about";
    }

    //handling Iteration
    @GetMapping(value="/iterate")
    public String iterateHandler(Model m) {
        //create a list or collection
        List<String> names = List.of("shivam","chavi","ankit","shubhi");
        m.addAttribute("names",names);
        return "iterate";
    }
}
