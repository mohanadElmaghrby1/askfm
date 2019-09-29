package com.mohannad.askfm.model;

import org.hibernate.annotations.CreationTimestamp;

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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false, updatable = false)
    @CreationTimestamp
    private Date createDate;

    //every question has sender
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "sender_id")
    private User senderUser;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "receiver_id")
    private User receiverUser;


    @OneToOne(mappedBy="question",fetch= FetchType.LAZY,cascade=CascadeType.ALL)
    private Answer answer;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getSenderUser() {
        return senderUser;
    }

    public void setSenderUser(User senderUser) {
        this.senderUser = senderUser;
    }

    public User getReceiverUser() {
        return receiverUser;
    }

    public void setReceiverUser(User receiverUser) {
        this.receiverUser = receiverUser;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "content='" + content + '\'' +
                ", createDate=" + createDate +
                ", senderUser=" + senderUser +
                ", receiverUser=" + receiverUser +
                ", answer=" + answer +
                '}';
    }
}
