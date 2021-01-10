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
            return ApplicationDetails.From(em
                    .createQuery(
                            "SELECT a FROM Application a WHERE a.position.id = ?1 AND a.candidate.username = ?2",
                            Application.class)
                    .setParameter(1, positionId)
                    .setParameter(2, username)
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

    public void create(Integer positionId, Integer candidateId, String cvLink) {
        LOG.info("create application");

        // TODO: not tested
        User u = em.find(User.class, candidateId);
        Position p = em.find(Position.class, candidateId);
        Application a = new Application(p, u, cvLink);

        u.getApplications().add(a);
//        p.getApplications().add(a);

        em.persist(a);
    }

    public void delete(Integer positionId, Integer candidateId) {
        LOG.info("delete application");

        // TODO: not tested
        Application a = em.find(Application.class, new ApplicationId(positionId, candidateId));

        em.remove(a);
    }
}
