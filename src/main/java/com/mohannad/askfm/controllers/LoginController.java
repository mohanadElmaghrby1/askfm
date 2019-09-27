package com.mohannad.askfm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class LoginController {


    @RequestMapping("/login")
    public String getLogin(Principal principal){

        //if user already logged in display home page
        if (principal != null) {
            return "redirect:/home";
        }
        return "sign-in";
    }

}
