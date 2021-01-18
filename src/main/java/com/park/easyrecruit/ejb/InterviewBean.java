/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.ejb;

import com.park.easyrecruit.entity.Application;
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

    public boolean addInterview(String date, String interviewer, String typeOfInterview, String comment, Integer positionId, Integer candidateId) {
        LOG.info("Adding new interview");

        try {
            Application a = em
                    .createQuery(
                            "SELECT a FROM Application a WHERE a.position.id = ?1 AND a.candidate.id = ?2",
                            Application.class)
                    .setParameter(1, positionId)
                    .setParameter(2, candidateId)
                    .getSingleResult();
            
            Interview interview = new Interview();  
            interview.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
            interview.setInterviewer(interviewer);
            interview.setTypeOfInterview(typeOfInterview);
            interview.setComment(comment);
            a.setInterview(interview);
            interview.setApplication(a);
            em.persist(interview);
            return true;
        } catch(Exception e) {
            return false;
        }
    }   
}
