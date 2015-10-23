package com.gmail.mdiland.remindy.entity;

import java.util.Date;

/**
 * Created by mdiland on 2015-10-23.
 */
public class Reminder {
    private String text;
    private Date date;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
