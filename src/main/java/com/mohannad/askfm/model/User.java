package com.mohannad.askfm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * created by mohannad  on 13/09/19
 */
@Entity
public class User extends BaseEntity {

    @Column(name = "email", unique = true, nullable = false)
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;

    @Column(name = "password", nullable = false)
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    @JsonIgnore
    private String password;

    @Column(name = "username", nullable = false, unique = true)
    @Length(min = 5, message = "*Your username must have at least 5 characters")
    @NotEmpty(message = "*Please provide your name")
    private String username;

    @Column(name = "name")
    @NotEmpty(message = "*Please provide your name")
    private String name;

    @Column(name = "last_name")
    @NotEmpty(message = "*Please provide your last name")
    private String lastName;

    @Column(name = "active", nullable = false)
    private int active;

    private String birthDay;
    private String gender;
    private String location;
    private String bio;
//    private String web;
//    private String hashTags;
//    private byte allowAnonQuestion; // Allow anonymous questions ?
//    private byte allowSharePosts; // >Allow other users to share posts ?
//    private byte showStatus;
    private String profileImagePath;  // upload image in file and store path
    private String backgroundImagePath;

    //every users have a lot of followers
    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    private Set<Follower> followers= new HashSet<>();

    //every users have a lot of followers
    @OneToMany(mappedBy="follower", cascade = CascadeType.ALL)
    private Set<Follower> following= new HashSet<>();

    /*every user  have a list of questions asked by others*/
    @OneToMany(mappedBy = "receiverUser", cascade = CascadeType.ALL)
    private Set<Question> received_questions = new HashSet<>();

    /*every user  can ask questions to others */
    @OneToMany(mappedBy = "senderUser", cascade = CascadeType.ALL)
    private Set<Question> sent_questions = new HashSet<>();

    /*every user  have a list of answers */
    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    private Set<Answer> answers = new HashSet<>();

    /*every user  have a list of notifications */
    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    private Set<Notification> notifications = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Like> like;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

//    public String getWeb() {
//        return web;
//    }
//
//    public void setWeb(String web) {
//        this.web = web;
//    }
//
//    public String getHashTags() {
//        return hashTags;
//    }
//
//    public void setHashTags(String hashTags) {
//        this.hashTags = hashTags;
//    }
//
//    public byte getAllowAnonQuestion() {
//        return allowAnonQuestion;
//    }
//
//    public void setAllowAnonQuestion(byte allowAnonQuestion) {
//        this.allowAnonQuestion = allowAnonQuestion;
//    }
//
//    public byte getAllowSharePosts() {
//        return allowSharePosts;
//    }
//
//    public void setAllowSharePosts(byte allowSharePosts) {
//        this.allowSharePosts = allowSharePosts;
//    }
//
//    public byte getShowStatus() {
//        return showStatus;
//    }
//
//    public void setShowStatus(byte showStatus) {
//        this.showStatus = showStatus;
//    }

    public String getProfileImagePath() {
        return profileImagePath;
    }

    public void setProfileImagePath(String profileImagePath) {
        this.profileImagePath = profileImagePath;
    }

    public String getBackgroundImagePath() {
        return backgroundImagePath;
    }

    public void setBackgroundImagePath(String backgroundImagePath) {
        this.backgroundImagePath = backgroundImagePath;
    }

    public Set<Follower> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<Follower> followers) {
        this.followers = followers;
    }

    public Set<Question> getReceived_questions() {
        return received_questions;
    }

    public void setReceived_questions(Set<Question> received_questions) {
        this.received_questions = received_questions;
    }

    public Set<Question> getSent_questions() {
        return sent_questions;
    }

    public void setSent_questions(Set<Question> sent_questions) {
        this.sent_questions = sent_questions;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    public Set<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Set<Notification> notifications) {
        this.notifications = notifications;
    }

    public Set<Like> getLike() {
        return like;
    }

    public void setLike(Set<Like> like) {
        this.like = like;
    }

    public Set<Follower> getFollowing() {
        return following;
    }

    public void setFollowing(Set<Follower> following) {
        this.following = following;
    }
}
