/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.ejb;

import com.park.easyrecruit.entity.*;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author andrei
 */
@Stateless
public class ApplicationBean {

    private static final Logger LOG = Logger.getLogger(PositionBean.class.getName());

    @PersistenceContext
    private EntityManager em;

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
        LOG.info("create application");
        
        // TODO: not tested
        
        Application a = em.find(Application.class, new ApplicationId(positionId, candidateId));
        
        em.remove(a);
    }
}
