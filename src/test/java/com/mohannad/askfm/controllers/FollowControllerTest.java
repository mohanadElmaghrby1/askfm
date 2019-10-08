package com.mohannad.askfm.controllers;

import com.mohannad.askfm.model.Follower;
import com.mohannad.askfm.model.User;
import com.mohannad.askfm.services.FollowerService;
import com.mohannad.askfm.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.security.Principal;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.jws.soap.SOAPBinding;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class FollowControllerTest {

    @Mock
    UserService userService;

    @Mock
    FollowerService followerService;

    @Mock
    Principal principal;

    MockMvc mockMvc;

    FollowController followController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        followController=new FollowController(userService, followerService);
        mockMvc = MockMvcBuilders.standaloneSetup(followController).build();
    }

    @Test
    void followAndUnFollow() throws Exception {
        Follower followerRelations = new Follower();
        //create followed user
        User followed = new User();
        followed.setUsername("samy");
        followerRelations.setUser(followed);
        when(userService.findByUserName(any())).thenReturn(followed);
        mockMvc.perform(get("/follow/samy").param("username","samy"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/samy"));

    }


    @Test
    void getFriends() throws Exception {
        when(principal.getName()).thenReturn("any");
        User user = new User();
        user.setId(1l);
        user.setUsername("momoo");
        when(userService.findByUserName(anyString())).thenReturn(user);

        ArrayList<Follower> following = new ArrayList<>();
        following.add(new Follower());
        following.add(new Follower());
        following.add(new Follower());

        when(followerService.getFollowing(any())).thenReturn(following);
        mockMvc.perform(get("/friends.html"))
                .andExpect(status().isOk())
                .andExpect(view().name("friends"));

    }
}