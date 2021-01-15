/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.ejb;

import com.park.easyrecruit.common.ApplicationDetails;
import com.park.easyrecruit.entity.*;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ejb.EJBException;
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
            return ApplicationDetails.From(em
                    .createQuery(
                            "SELECT a FROM Application a WHERE a.position.id = ?1 AND a.candidate.id = ?2",
                            Application.class)
                    .setParameter(1, positionId)
                    .setParameter(2, candidateId)
                    .getSingleResult());
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
        LOG.info("create application");

        try {
            Application a = getApplication(positionId, username);
            a.setCvLink(ad.getCvLink());
        } catch (Exception e) {
            Position p = em.find(Position.class, positionId);
            User u = em
                    .createQuery("SELECT u FROM User u WHERE u.username = ?1", User.class)
                    .setParameter(1, username)
                    .getSingleResult();
            Application a = new Application(p, u, ad.getCvLink());
            u.getApplications().add(a);
            p.getApplications().add(a);
            em.persist(a);
        }
    }

    public void delete(Integer positionId, String username) {
        LOG.info("delete application");

        Application a = getApplication(positionId, username);
        if (a != null)
            em.remove(a);
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

    public Collection<ApplicationDetails> getAll() {
        LOG.info("get all applications");
        Collection<ApplicationDetails> c = em
                .createQuery("SELECT a FROM Application a", Application.class)
                .getResultStream()
                .map(a -> ApplicationDetails.From(a))
                .collect(Collectors.toList());
        return c;
    }
    
}
