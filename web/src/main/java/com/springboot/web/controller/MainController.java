package com.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.core.SpringVersion;

@Controller
public class MainController {
    
    @RequestMapping("/")
    public String home() {
        System.out.println("This is the home page");
        return "home";
    }

    @RequestMapping("/contact")
    public String contact() {
        System.out.println("This is the contact page");
        return "contact";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        int a = 99;
        int b = 89;
        return "this is just testing sum of a and b is " + (a+b);
    }

    @RequestMapping("/springVersion")
    @ResponseBody
    public String version() {
        return "Spring Framework version: " + SpringVersion.getVersion();
    }

}
