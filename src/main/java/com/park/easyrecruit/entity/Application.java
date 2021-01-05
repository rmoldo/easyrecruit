/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.entity;

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

    public Application(Position position, User candidate, String cvLink) {
        this.position = position;
        this.candidate = candidate;
        this.cvLink = cvLink;
    }

    private String cvLink;

    @Id
    @ManyToOne
    @JoinColumn(name = "positionId")
    private Position position;

    @Id
    @ManyToOne
    @JoinColumn(name = "candidateId")
    private User candidate;

    @OneToMany(mappedBy = "application")
    private Collection<ApplicationComment> comments = new ArrayList<>();

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

}
