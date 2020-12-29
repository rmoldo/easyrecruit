/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.ejb;

import com.park.easyrecruit.common.PositionDetails;
import com.park.easyrecruit.entity.Position;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Silvan
 */
@Stateless
public class PositionBean {

    private static final Logger LOG = Logger.getLogger(PositionBean.class.getName());

    @PersistenceContext
    private EntityManager em;
    
    public List<PositionDetails> getAllPositions() {
        LOG.info("get all positions");
        
        try {
            List<Position> positions = (List<Position>) em.createQuery("SELECT p FROM Position p").getResultList();
            return copyPositionsToDetails(positions);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }    
    }

    private List<PositionDetails> copyPositionsToDetails(List<Position> positions) {
    	List<PositionDetails> detailsList = new ArrayList<>();

    	for (Position position : positions) {
			PositionDetails positionDetails = new PositionDetails(position.getId(),
                            position.getName(),
                            position.getDescription(),
                            position.getIsOpen(),
                            position.getComments());
			detailsList.add(positionDetails);
    	}

    	return detailsList;
    } 
}
