package com.mohannad.askfm.commands;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotNull;

public class UserCommand {
    private Long id;

    @Length(min = 5, message = "*Your username must have at least 5 characters")
    @NotNull(message = "*Please provide your name")
    private String username;

    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotNull(message = "*Please provide your password")
    private String password;

    @Length(min = 5, message = "*Your email must have at least 5 characters")
    @NotNull(message = "*Please provide your email")
    private String email;

    @Length(min = 5, message = "*Your name must have at least 5 characters")
    @NotNull(message = "*Please provide your name")
    private String name;
    private Integer birthDay;
    private Integer birthMonth;
    private Integer birthYear;
    private String gender;
    private String language;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Integer birthDay) {
        this.birthDay = birthDay;
    }

    public Integer getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(Integer birthMonth) {
        this.birthMonth = birthMonth;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "UserCommand{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", birthMonth=" + birthMonth +
                ", birthYear=" + birthYear +
                ", gender='" + gender + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
