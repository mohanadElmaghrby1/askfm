package com.mohannad.askfm.repositories;

import com.mohannad.askfm.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * integration testing for UserRepository class
 */
@ExtendWith(SpringExtension.class) //to load spring context
@SpringBootTest
class UserRepositoryIT {

    @Autowired
    UserRepository userRepository;

    @Test
    void findByUsername() {
        User savedUser = userRepository.findByUsername("Mohannad_Elmaghrby");
        assertEquals(savedUser.getUsername(),"Mohannad_Elmaghrby" );
    }

    @Test
    void findByEmail() {
        User savedUser = userRepository.findByEmail("mohanad20201996@gmail.com");
        assertEquals(savedUser.getEmail(),"mohanad20201996@gmail.com" );
    }
}