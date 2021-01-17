/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.ejb;

import com.park.easyrecruit.common.ApplicationCommentDetails;
import com.park.easyrecruit.common.ApplicationDetails;
import com.park.easyrecruit.common.Status;
import com.park.easyrecruit.entity.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author andrei
 */
@Stateless
public class ApplicationBean {

    private static final Logger LOG = Logger.getLogger(PositionBean.class.getName());

    @PersistenceContext
    private EntityManager em;

    public ApplicationDetails get(Integer positionId, String username) {
        LOG.info("get application for position & username");

        try {
            return ApplicationDetails.From(getApplication(positionId, username));
        } catch (Exception e) {
            return null;
        }
    }

    public ApplicationDetails get(Integer positionId, Integer candidateId) {
        LOG.info("get application for position & candidateId");

        try {
            return ApplicationDetails.From(getApplication(positionId, candidateId));
        } catch (Exception e) {
            return null;
        }
    }

    public Collection<ApplicationDetails> getMany(String username) {
        LOG.info("get many applications for username");

        return em
                .createQuery("SELECT a FROM Application a WHERE a.candidate.username = ?1", Application.class)
                .setParameter(1, username)
                .getResultStream()
                .map(a -> ApplicationDetails.From(a))
                .collect(Collectors.toList());
    }

    public void save(Integer positionId, String username, ApplicationDetails ad) {
        LOG.info("save application");

        try {
            Application a = getApplication(positionId, username);
            a.setCvLink(ad.getCvLink());
        } catch (Exception e) {
            Position p = em.find(Position.class, positionId);
            User u = getUser(username);
            Application a = new Application(p, u, ad.getCvLink(), Status.OPEN);
            u.getApplications().add(a);
            em.persist(a);
        }
    }

    public ApplicationCommentDetails createComment(Integer positionId, Integer candidateId, String username, ApplicationCommentDetails acd) {
        LOG.info("save comment");

        User u = getUser(username);
        Application a = getApplication(positionId, candidateId);
        if (u == null || a == null) {
            return null;
        }

        ApplicationComment ac = acd.toApplicationComment();
        ac.setDateTime(LocalDateTime.now());
        ac.setUser(u);
        ac.setApplication(a);
        a.getComments().add(ac);
        em.persist(ac);
        return new ApplicationCommentDetails(ac);
    }

    public void delete(Integer positionId, String username) {
        LOG.info("delete application");

        Application a = getApplication(positionId, username);
        if (a != null) {
            em.remove(a);
        }
    }

    public boolean deleteComment(int id, String username) {
        LOG.info("delete comment");

        ApplicationComment ac = em.find(ApplicationComment.class, id);
        if (ac != null && ac.getUser().getUsername().equals(username)) {
            ac.getApplication().getComments().remove(ac);
            em.remove(ac);
            return true;
        }
        return false;
    }

    public ApplicationCommentDetails updateComment(int id, String username, ApplicationCommentDetails acd) {
        LOG.info("update comment");

        ApplicationComment ac = em.find(ApplicationComment.class, id);
        if (ac == null || !ac.getUser().getUsername().equals(username)) {
            return null;
        }

        ac.setText(acd.getText());
        return new ApplicationCommentDetails(ac);
    }

    private Application getApplication(Integer positionId, String username) {
        try {
            return em
                    .createQuery(
                            "SELECT a FROM Application a WHERE a.position.id = ?1 AND a.candidate.username = ?2",
                            Application.class)
                    .setParameter(1, positionId)
                    .setParameter(2, username)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
  
    private Application getApplication(Integer positionId, Integer candidateId) {
        try {
            return em
                    .createQuery(
                            "SELECT a FROM Application a WHERE a.position.id = ?1 AND a.candidate.id = ?2",
                            Application.class)
                    .setParameter(1, positionId)
                    .setParameter(2, candidateId)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    private User getUser(String username) {
        return em
                .createQuery("SELECT u FROM User u WHERE u.username = ?1", User.class)
                .setParameter(1, username)
                .getSingleResult();
    }
  
    public Collection<ApplicationDetails> getAll() {
        LOG.info("get all applications");
        Collection<ApplicationDetails> c = em
                .createQuery("SELECT a FROM Application a", Application.class)
                .getResultStream()
                .map(a -> ApplicationDetails.From(a))
                .collect(Collectors.toList());
        return c;
    }
    
    public void executeAction(String action, Integer positionId, String username) {
        LOG.info("approve or reject application");
        
        Application a = getApplication(positionId, username);
        if (action.equals("approve")) {
            Position p = em.find(Position.class, positionId);
            a.setStatus(Status.APPROVED);
            Integer nbOfCandidates = p.getNbOfCandidatesNeeded();
            if (nbOfCandidates.equals(1)) {
                p.setIsOpen(false);
            }
            p.setNbOfCandidatesNeeded(nbOfCandidates - 1); 
        }
        else {
            a.setStatus(Status.REJECTED);
        }
    }
}
