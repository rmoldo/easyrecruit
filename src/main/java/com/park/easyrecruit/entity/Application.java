/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.entity;

import com.park.easyrecruit.common.Status;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author andrei
 */
@Entity
@IdClass(ApplicationId.class)
@Table(name = "Applications")
public class Application implements Serializable {

    private static final long serialVersionUID = 2L;

    public Application() {
    }

    public Application(Position position, User candidate, String cvLink, Status status) {
        this.position = position;
        this.candidate = candidate;
        this.cvLink = cvLink;
        this.status = status;
    }

    private String cvLink;
    private Status status;

    @Id
    @ManyToOne
    @JoinColumn(name = "positionId")
    private Position position;

    @Id
    @ManyToOne
    @JoinColumn(name = "candidateId")
    private User candidate;

    @OneToMany(mappedBy = "application")
    private Collection<ApplicationComment> comments;
    private Collection<ApplicationComment> comments = new ArrayList<>();
    
    @OneToOne
    private Interview interview;

    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
    }
    
    public Collection<ApplicationComment> getComments() {
        return comments;
    }

    public Position getPosition() {
        return position;
    }

    public User getCandidate() {
        return candidate;
    }

    public String getCvLink() {
        return cvLink;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCvLink(String cvLink) {
        this.cvLink = cvLink;
    }

    public void setComments(Collection<ApplicationComment> comments) {
        this.comments = comments;
    }
}
