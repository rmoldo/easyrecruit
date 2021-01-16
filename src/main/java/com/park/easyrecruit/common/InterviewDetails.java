/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.common;

import com.park.easyrecruit.entity.Application;
import com.park.easyrecruit.entity.Interview;
import java.util.Date;
import javax.persistence.OneToOne;

/**
 *
 * @author Dragos
 */
public class InterviewDetails {
    private Integer id;
    private Date date;
    private String interviewer;
    private String typeOfInterview;
    private String comment;
    private Application application;
    
    public InterviewDetails(Interview i){
       this(i.getId(),
            i.getDate(),
            i.getInterviewer(),
            i.getTypeOfInterview(),
            i.getComment(),
            i.getApplication());
    }
    
    public InterviewDetails(Integer id, Date date, String interviewer, String typeOfInterview, String comment, Application application) {
        this.id = id;
        this.date = date;
        this.interviewer = interviewer;
        this.typeOfInterview = typeOfInterview;
        this.comment = comment;
        this.application = application;
    }

    public Integer getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public String getTypeOfInterview() {
        return typeOfInterview;
    }

    public String getComment() {
        return comment;
    }

    public Application getApplication() {
        return application;
    }

    
    
}
