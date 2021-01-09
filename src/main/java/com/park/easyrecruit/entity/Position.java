/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Silvan
 */
@Entity
@Table(name = "POSITIONS")
public class Position implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String department;
    private String project;
    private String requirements;
    private String responsibilities;
    private Boolean isOpen;
    private Integer nbOfCandidatesNeeded;
    private String creatorUserName;

    public Integer getNbOfCandidatesNeeded() {
        return nbOfCandidatesNeeded;
    }

    public void setNbOfCandidatesNeeded(Integer nbOfCandidatesNeeded) {
        this.nbOfCandidatesNeeded = nbOfCandidatesNeeded;
    }
    @OneToMany(
        mappedBy = "position",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<PositionComment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "position")
    private Collection<Application> applications = new ArrayList<>();

    public Collection<Application> getApplications() {
        return applications;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatorUserName() {
        return creatorUserName;
    }

    public void setCreatorUserName(String creatorUserName) {
        this.creatorUserName = creatorUserName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }


    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    public List<PositionComment> getComments() {
        return comments;
    }

    public void setComments(List<PositionComment> comments) {
        this.comments = comments;
    }

    public void addComment(PositionComment comment) {
        comments.add(comment);
        comment.setPosition(this);
    }
    public void removeComment(PositionComment comment) {
        comments.remove(comment);
        comment.setPosition(null);
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Position)) {
            return false;
        }
        Position other = (Position) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.park.easyrecruit.entity.Position[ id=" + id + " ]";
    }

}
