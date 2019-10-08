package com.mohannad.askfm.controllers;

import com.mohannad.askfm.model.Answer;
import com.mohannad.askfm.model.User;
import com.mohannad.askfm.services.AnswerService;
import com.mohannad.askfm.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

/**
 * create by mohannad on 9/25/2019
 */
@Controller
public class IndexController {

    private AnswerService answerService;
    private UserService userService;


    public IndexController(AnswerService answerService, UserService userService) {
        this.answerService = answerService;
        this.userService = userService;
    }

    @GetMapping({"/","/home", "/index.html"})
    public String loadAnswersToHomePage(Model model , Principal principal){
        //get logged in user
        User loggedInUser= userService.findByUserName(principal.getName());

        //get all following answered questions
        List<Answer> allFollowedUsersAnswers = answerService.findAllFollowedUsersAnswers(loggedInUser.getId().toString());
        allFollowedUsersAnswers.forEach(answer -> {
            System.out.println("loaded ans :"+answer.getContent());
        });
        model.addAttribute("answers" , allFollowedUsersAnswers);
        return "index";
    }



}
