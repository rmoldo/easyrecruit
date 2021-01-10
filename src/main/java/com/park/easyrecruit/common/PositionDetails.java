/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.common;

import com.park.easyrecruit.entity.Position;
import com.park.easyrecruit.entity.PositionComment;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Silvan
 */
public class PositionDetails implements Serializable {

    private Integer id;
    private String name;
    private String department;
    private String project;
    private String requirements;
    private String responsibilities;
    private Boolean isOpen;
    private Integer nbOfCandidatesNeeded;
    private String creatorUserName;
    private List<PositionComment> comments = new ArrayList<>();

    public PositionDetails(Position position) {
        this(position.getId(),
                position.getName(),
                position.getDepartment(),
                position.getProject(),
                position.getRequirements(),
                position.getResponsibilities(),
                position.getIsOpen(),
                position.getNbOfCandidatesNeeded(),
                position.getCreatorUserName(),
                position.getComments());
    }

    public PositionDetails(Integer id, String name, String department, String project, String requirements, String responsibilities, Boolean isOpen, Integer nbOfCandidatesNeeded, String creatorUserName, List<PositionComment> comments) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.project = project;
        this.requirements = requirements;
        this.responsibilities = responsibilities;
        this.isOpen = isOpen;
        this.nbOfCandidatesNeeded = nbOfCandidatesNeeded;
        this.creatorUserName = creatorUserName;
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getProject() {
        return project;
    }

    public String getRequirements() {
        return requirements;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public Boolean getIsOpen() {
        return isOpen;
    }

    public Integer getNbOfCandidatesNeeded() {
        return nbOfCandidatesNeeded;
    }

    public String getCreatorUserName() {
        return creatorUserName;
    }

    public List<PositionComment> getComments() {
        return comments;
    }

}
