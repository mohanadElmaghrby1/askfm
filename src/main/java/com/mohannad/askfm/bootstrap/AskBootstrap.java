package com.mohannad.askfm.bootstrap;

import com.mohannad.askfm.model.Answer;
import com.mohannad.askfm.model.Like;
import com.mohannad.askfm.model.Question;
import com.mohannad.askfm.model.User;
import com.mohannad.askfm.repository.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    private final LikeRepository likeRepository;

    public AskBootstrap(UserRepository userRepository, QuestionRepository questionRepository,
                        AnswerRepository answerRepository, NotificationRepository notificationRepository,
                        FollowerRepository followerRepository,LikeRepository likeRepository) {
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.notificationRepository = notificationRepository;
        this.followerRepository = followerRepository;
        this.likeRepository=likeRepository;
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


        //create a answer1
        Answer answer1 = new Answer();
        answer1.setContent("iam a 20 years old");
        answer1.setDate(new Date(2019,9,15));

        //create a question
        Question question12 = new Question();
        question12.setContent("where are you from?");
        question12.setDate(new Date(2019,9,16));

        //create a answer1
        Answer answer12 = new Answer();
        answer12.setContent("iam from alex");
        answer12.setDate(new Date(2019,9,16));


        //create like
        Like like1 = new Like();
        //create like
        Like like2 = new Like();
        //first create set and assign then single
        //assign many first
        Set<Like> likeSet = new HashSet<>();
        likeSet.add(like1);
        likeSet.add(like2);
        answer1.setLikes(likeSet);
        like1.setUser(user);
        like2.setUser(user);
        answer1.setQuestion(question1);
        answer1.setUser(user);
        like1.setAnswer(answer1);
        like2.setAnswer(answer1);
        HashSet<Question>questionHashSet = new HashSet<>();
        questionHashSet.add(question1);
        user.setReceived_questions(questionHashSet);
        question1.setSenderUser(user);
        question1.setReceiverUser(user);
        userRepository.save(user);
        questionRepository.save(question1);
        answerRepository.save(answer1);
        likeRepository.save(like1);
        likeRepository.save(like2);


    }
}
