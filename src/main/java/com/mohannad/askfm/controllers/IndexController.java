package com.mohannad.askfm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    @RequestMapping("/login")
    public String getLogin(){
        return "sign-up";
    }
}