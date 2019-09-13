package com.mohannad.askfm.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * created by mohannad  on 13/09/19
 */
@Entity
@Table(name="likes")
public class Like extends BaseEntity {

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
