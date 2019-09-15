package com.mohannad.askfm.model;

import javax.persistence.*;
import java.util.Date;

/**
 * created by mohannad  on 13/09/19
 */
@Entity
public class Question extends BaseEntity {

    /*question content */
    private String content ;
    /*question date  */
    private Date date;
    //every question has sender
    @ManyToOne
    @JoinColumn(name="receiver_id")
    private User user;

    @OneToOne(mappedBy="question",fetch= FetchType.LAZY,cascade=CascadeType.ALL)
    private Answer answer;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
