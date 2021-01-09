/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.ejb;

import com.park.easyrecruit.common.PositionDetails;
import com.park.easyrecruit.entity.Position;
import com.park.easyrecruit.entity.PositionComment;
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

    public Boolean addPosition(String name, String description, Integer nbOfCandidatesNeeded, String creatorUserName) {
         LOG.info("Position Bean:Add position");

        try {
            Position position = new Position();

            position.setName(name);
            position.setDescription(description);
            position.setIsOpen(false);
            position.setNbOfCandidatesNeeded(nbOfCandidatesNeeded);
            position.setCreatorUserName(creatorUserName);
            em.persist(position);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public List<PositionDetails> getAllPositions() {
        LOG.info("get all positions");

        try {
            List<Position> positions = (List<Position>) em.createQuery("SELECT p FROM Position p").getResultList();
            return copyPositionsToDetails(positions);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private Position getPositionById(Integer positionId) {
        LOG.info("get position by id");

        try {
            Position position = em.find(Position.class, positionId);
            return position;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public Boolean addComment(Integer positionId, String creatorUser, String text) {
        try {
            Position position = getPositionById(positionId);
            PositionComment comment = new PositionComment();

            comment.setCreatorUser(creatorUser);
            comment.setPosition(position);
            comment.setText(text);
            position.addComment(comment);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    private List<PositionDetails> copyPositionsToDetails(List<Position> positions) {
    	List<PositionDetails> detailsList = new ArrayList<>();

    	for (Position position : positions) {
			PositionDetails positionDetails = new PositionDetails(position.getId(),
                            position.getName(),
                            position.getDescription(),
                            position.getIsOpen(),
                            position.getNbOfCandidatesNeeded(),
                            position.getCreatorUserName(),
                            position.getComments());
			detailsList.add(positionDetails);
    	}

    	return detailsList;
    }
}
