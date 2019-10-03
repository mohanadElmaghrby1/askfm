package com.mohannad.askfm.controllers;

import com.mohannad.askfm.model.Answer;
import com.mohannad.askfm.services.AnswerService;
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

    AnswerService answerService;

    public IndexController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping({"/","/home", "/index.html"})
    public String loadAnswersToHomePage(Model model){
        List<Answer> allAnswers = answerService.findAll();
        model.addAttribute("answers" , allAnswers);
        List<Answer> allFollowedUsersAnswers = answerService.findAllFollowedUsersAnswers();
        allFollowedUsersAnswers.forEach(answer -> {
            System.out.println("loaded ans :"+answer.getContent());
        });
        return "index";
    }



}
