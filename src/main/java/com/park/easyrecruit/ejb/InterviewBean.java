/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.ejb;

import com.park.easyrecruit.entity.Interview;
import com.park.easyrecruit.servlet.interview.Interviews;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dragos
 */
@Stateless
public class InterviewBean {
private static final Logger LOG = Logger.getLogger(InterviewBean.class.getName());

    @PersistenceContext
    private EntityManager em;

    public boolean addInterview(String date, String interviewer, String typeOfInterview, String comment) {
        LOG.info("Adding new interview");

        try {
            Interview interview = new Interview();  
            interview.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(date));
            interview.setInterviewer(interviewer);
            interview.setTypeOfInterview(typeOfInterview);
            interview.setComment(comment);
            em.persist(interview);
            return true;
        } catch(Exception e) {
            return false;
        }
    }   
}
