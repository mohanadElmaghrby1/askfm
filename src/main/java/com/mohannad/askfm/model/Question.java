package com.mohannad.askfm.model;

import javax.persistence.Entity;
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
}
