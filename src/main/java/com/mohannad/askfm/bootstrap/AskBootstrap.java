package com.mohannad.askfm.bootstrap;

import com.mohannad.askfm.model.*;
import com.mohannad.askfm.repositories.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
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

        /*password encoder*/
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();




        //create a user
        User user = new User();
        user.setUsername("Mohannad_Elmaghrby");
        user.setName("Mohannad ELmaghrby");
        user.setEmail("mohanad20201996@gmail.com");
        user.setActive(0);
        user.setBirthDay("20-2-1996");
        user.setGender("male");
        user.setBio("software developer");
        user.setLocation("kom hamada");
        user.setPassword(encoder.encode("123456"));
        user.setProfileImagePath("www.com");
        user.setBackgroundImagePath("www.comB");

        Role userRole = new Role();
        userRole.setRole("USER");
        user.setRoles(new HashSet<Role>(Collections.singleton(userRole)));


        //create user 2
        User user2=new User();
        user2.setName("fady hamdy");
        user2.setPassword(encoder.encode("12345678"));
        user2.setUsername("fady1");
        user2.setActive(1);
        user2.setEmail("mohanad20d201996a@gmail.com");
        user2.setBirthDay("20-2-1996");
        user2.setGender("male");
        user2.setBio("software developer");
        user2.setLocation("kom hamada");
        user2.setProfileImagePath("www.com");
        user2.setBackgroundImagePath("www.comB");



        //create user 2
        User user3=new User();
        user3.setName("soso hamdy");
        user3.setPassword(encoder.encode("12345678"));
        user3.setUsername("sosoham");
        user3.setActive(1);
        user3.setEmail("mohanad20201996a@gmail.com");
        user3.setBirthDay("20-2-1996");
        user3.setGender("male");
        user3.setBio("software developer");
        user3.setLocation("kom hamada");
        user3.setProfileImagePath("www.com");
        user3.setBackgroundImagePath("www.comB");

        userRepository.save(user);
        userRepository.save(user2);
        userRepository.save(user3);
    }
}
