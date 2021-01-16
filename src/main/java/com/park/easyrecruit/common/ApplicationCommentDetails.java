/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.common;

import com.park.easyrecruit.entity.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 *
 * @author andrei
 */
public class ApplicationCommentDetails {

    private int id;
    private User user;
    private String text;
    private LocalDateTime time;

    public ApplicationCommentDetails() {
    }

    public ApplicationCommentDetails(ApplicationComment ac) {
        id = ac.getId();
        user = ac.getUser();
        text = ac.getText();
        time = ac.getDateTime();
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getTimeString() {
        return time.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    
    public ApplicationComment toApplicationComment() {
        ApplicationComment ac = new ApplicationComment();
        ac.setId(id);
        ac.setText(text);
        ac.setUser(user);
        ac.setDateTime(time);
        return ac;
    }

    public String toJsonString() {
        return String.format(
                "{"
                + "\"id\": %d,"
                + "\"text\": \"%s\","
                + "\"username\": \"%s\","
                + "\"time\": \"%s\""
                + "}",
                id, text, user.getFullName(),
                time.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
    }
}
