package com.mohannad.askfm.services;

import com.mohannad.askfm.commands.UserCommand;
import com.mohannad.askfm.convertors.UserCommandToUser;
import com.mohannad.askfm.convertors.UserToUserCommand;
import com.mohannad.askfm.exceptions.NotFoundException;
import com.mohannad.askfm.model.Role;
import com.mohannad.askfm.model.User;
import com.mohannad.askfm.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserToUserCommand userToUserCommand;
    private UserCommandToUser userCommandToUser;
    private PasswordEncoder passwordEncoder;
    private RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, UserToUserCommand userToUserCommand,
                           UserCommandToUser userCommandToUser , PasswordEncoder passwordEncoder,RoleService roleService) {
        this.userRepository = userRepository;
        this.userToUserCommand = userToUserCommand;
        this.userCommandToUser = userCommandToUser;
        this.passwordEncoder=passwordEncoder;
        this.roleService=roleService;
    }

    @Override
    public UserCommand saveUserCommand(UserCommand userCommand) {
        userCommand.setPassword(passwordEncoder.encode(userCommand.getPassword()));
        User user = userCommandToUser.convert(userCommand);
        //set user role
        Role userRole = roleService.findByRole("USER");
        user.setRoles(new HashSet<Role>(Collections.singleton(userRole)));
        userRepository.save(user);
        return userToUserCommand.convert(user);
    }

    @Override
    public User findByID(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent())
            throw new NotFoundException("User not found. for id value:"+id.toString());
        return userOptional.get();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public UserCommand findCommandById(Long id) {
        return null;
    }

    @Override
    public User findByUserName(String username) {
        User user = userRepository.findByUsername(username);
        if (user==null)
            throw new NotFoundException("User not found. for id value:"+username);
        return user;
    }

    @Override
    public User findByUserNameWithNull(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }


}
