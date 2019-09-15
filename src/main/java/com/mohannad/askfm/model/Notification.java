package com.mohannad.askfm.model;

import javax.persistence.*;
import java.util.Date;

/**
 * created by mohannad  on 13/09/19
 */
@Entity
public class Notification extends BaseEntity {

    private String content;
    private Date time;
    @Enumerated(value = EnumType.ORDINAL)
    private NotificationType type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
