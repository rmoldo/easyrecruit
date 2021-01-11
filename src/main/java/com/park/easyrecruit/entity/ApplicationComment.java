/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author andrei
 */
@Entity
@Table(name = "ApplicationComments")
public class ApplicationComment implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private User user;  
    
    private String text;

    @ManyToOne
    private Application application;

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public Application getApplication() {
        return application;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof ApplicationComment)) {
            return false;
        }

        ApplicationComment other = (ApplicationComment) o;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }
}
