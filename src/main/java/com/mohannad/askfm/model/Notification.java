package com.mohannad.askfm.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
}
