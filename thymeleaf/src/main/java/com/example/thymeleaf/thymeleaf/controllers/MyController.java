package com.example.thymeleaf.thymeleaf.controllers;

import java.time.LocalDateTime;
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

    //handling for conditional statements
    @GetMapping("/condition")
    public String conditionhandler(Model m) {
        System.out.println("Conditional handler executed");
        m.addAttribute("isActive", true);
        m.addAttribute("gender", "M");

        List<Integer> myList = List.of(127,123,323,443,55);
        m.addAttribute("myList", myList);
        return "condition";
    }

    //handler for including fragments
    @GetMapping(value = "/services")
    public String mainHandler(Model m) {
        m.addAttribute("title", "I like to eat pizza");
        m.addAttribute("subtitle", LocalDateTime.now().toString());
        return "service";
    }

    //for new about
    @GetMapping(value = "/newAbout")
    public String newAbout() {
        return "aboutNew";
    }

    //for new about
    @GetMapping(value = "/content")
    public String content() {
        return "content";
    }
}
