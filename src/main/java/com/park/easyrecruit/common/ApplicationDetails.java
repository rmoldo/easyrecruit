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
public class ApplicationDetails {
    
    private String cvLink;
    private UserDetails candidate;
    private Integer editableCommentsUserId = null;
    private List<ApplicationComment> comments = new ArrayList<>();
    private PositionDetails position;
    
    public static ApplicationDetails From(Application a) {
        if (a == null)
            return null;
        
        ApplicationDetails ad = new ApplicationDetails();
        ad.cvLink = a.getCvLink();
        ad.candidate = new UserDetails(a.getCandidate());
        ad.comments = new ArrayList<>(a.getComments());
        ad.position = new PositionDetails(a.getPosition());
        return ad;
    }

    public List<ApplicationComment> getComments() {
        return comments;
    }

    public UserDetails getCandidate() {
        return candidate;
    }

    public String getCvLink() {
        return cvLink;
    }

    public PositionDetails getPosition() {
        return position;
    }

    public void setCvLink(String cvLink) {
        this.cvLink = cvLink;
    }

    public void setCandidate(UserDetails candidate) {
        this.candidate = candidate;
    }

    public void setComments(List<ApplicationComment> comments) {
        this.comments = comments;
    }

    public void setPosition(PositionDetails position) {
        this.position = position;
    }

    public Integer getEditableCommentsUserId() {
        return editableCommentsUserId;
    }

    public void setEditableCommentsUserId(Integer editableCommentsUserId) {
        this.editableCommentsUserId = editableCommentsUserId;
    }
    
    
}
