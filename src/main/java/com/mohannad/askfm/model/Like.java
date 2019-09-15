package com.mohannad.askfm.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * created by mohannad  on 13/09/19
 */
@Entity
@Table(name="likes")
public class Like extends BaseEntity {

    private int count;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
