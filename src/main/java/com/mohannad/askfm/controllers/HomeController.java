package com.mohannad.askfm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * create by mohannad on 9/25/2019
 */
@Controller
public class HomeController {

    @GetMapping({"/home", "/index.html"})
    public String getHomePage(){
        return "index";
    }
}
