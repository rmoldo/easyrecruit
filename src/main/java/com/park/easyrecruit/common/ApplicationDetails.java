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
    private Collection<ApplicationComment> comments = new ArrayList<>();
    private PositionDetails position;
    private Status status;
    
    public static ApplicationDetails From(Application a) {
        if (a == null)
            return null;
        
        ApplicationDetails ad = new ApplicationDetails();                                  
        ad.cvLink = a.getCvLink();
        ad.candidate = new UserDetails(a.getCandidate());
        ad.comments = new ArrayList<>(a.getComments());
        ad.position = new PositionDetails(a.getPosition());
        ad.status = a.getStatus();
        return ad;
    }

    public Collection<ApplicationComment> getComments() {
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

    public Status getStatus() {
        return status;
    }
    
    public void setCvLink(String cvLink) {
        this.cvLink = cvLink;
    }

    public void setCandidate(UserDetails candidate) {
        this.candidate = candidate;
    }

    public void setComments(Collection<ApplicationComment> comments) {
        this.comments = comments;
    }

    public void setPosition(PositionDetails position) {
        this.position = position;
    }
}
