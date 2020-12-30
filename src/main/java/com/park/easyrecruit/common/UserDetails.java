/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.common;

import java.io.Serializable;

/**
 *
 * @author M Radu
 */
public class UserDetails implements Serializable{
    private Integer id;
    private String username;
    private String email;
    private String position;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public UserDetails(Integer id, String username, String email, String position, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.position = position;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPosition() {
        return position;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
