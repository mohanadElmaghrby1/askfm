package com.mohannad.askfm.bootstrap;

import com.mohannad.askfm.model.Answer;
import com.mohannad.askfm.model.Question;
import com.mohannad.askfm.model.User;
import com.mohannad.askfm.repository.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * created by mohannad on 15/09/2019
 */
@Component
public class AskBootstrap  implements ApplicationListener<ContextRefreshedEvent> {

    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository  answerRepository;
    private final NotificationRepository notificationRepository;
    private final FollowerRepository followerRepository;

    public AskBootstrap(UserRepository userRepository, QuestionRepository questionRepository,
                        AnswerRepository answerRepository, NotificationRepository notificationRepository,
                        FollowerRepository followerRepository) {
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.notificationRepository = notificationRepository;
        this.followerRepository = followerRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //create a question
        Question question1 = new Question();
        question1.setContent("how old are you?");
        question1.setDate(new Date(2019,9,15));

        //create a user
        User user = new User();
        user.setUserName("Mohannad_Elmaghrby");
        user.setFullName("Mohannad ELmaghrby");
        user.setEmail("mohanad20201996@gmail.com");
        user.setBirthDay("20-2-1996");
        user.setGender("male");
        user.setBio("software developer");
        user.setLocation("kom hamada");
        user.setPassWord("1234");
        user.setProfileImagePath("www.com");
        user.setBackgroundImagePath("www.comB");


        //create a answer
        Answer answer = new Answer();
        answer.setContent("iam a 20 years old");
        answer.setDate(new Date(2019,9,15));

        //relation
        answer.setQuestion(question1);
        question1.setAnswer(answer);
        answer.setUser(user);
        question1.setUser(user);



        userRepository.save(user);
        questionRepository.save(question1);
        answerRepository.save(answer);
    }
}
