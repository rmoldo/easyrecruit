/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.common;

import com.park.easyrecruit.entity.*;
import java.util.*;

/**
 *
 * @author andrei
 */
public class ApplicationCommentDetails {

    private int id;
    private User user;
    private String text;

    public ApplicationCommentDetails() {
    }

    public ApplicationCommentDetails(ApplicationComment ac) {
        id = ac.getId();
        user = ac.getUser();
        text = ac.getText();
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

    public ApplicationComment toApplicationComment() {
        ApplicationComment ac = new ApplicationComment();
        ac.setId(id);
        ac.setText(text);
        ac.setUser(user);
        return ac;
    }

    public String toJsonString() {
        return String.format(
                "{"
                + "\"id\": %d,"
                + "\"text\": \"%s\","
                + "\"username\": \"%s\","
                + "\"time\": \"20/19/1111 at 18:30\""
                + "}",
                id, text, user.getFullName());
    }
}
