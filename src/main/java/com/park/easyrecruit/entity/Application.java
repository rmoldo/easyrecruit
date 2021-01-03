/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author andrei
 */
@Entity
@IdClass(ApplicationId.class)
@Table(name = "APPLICATIONS")
public class Application implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    private Integer candidateId;
    
    @Id
    private Integer positionId;
    
    private String cvLink;
    
//    @OneToMany(
//        mappedBy = "position",
//        cascade = CascadeType.ALL,
//        orphanRemoval = true
//    )
//    private List<ApplicationComment> comments = new ArrayList<>();
}
