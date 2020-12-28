/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.ejb;

import com.park.easyrecruit.common.UserDetails;
import com.park.easyrecruit.entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author M Radu
 */
@Stateless
public class UserBean {

    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

    @PersistenceContext
    private EntityManager em;

    public boolean createUser(String username, String email, String hashedPassword, String position) {
        // Check if username or email is in the User database
        
        /*
        Query query = em.createQuery("SELECT u FROM User u WHERE u.username = uname" OR u.email = mail)
                .setParameter("uname", username);

        List<User> users = (List<User>) query.getResultList();

        if (users.size() != 0) {
            return false;
        }
        */
        
        try {
            Query query = em.createQuery("SELECT u FROM User u");
            List<User> users = (List<User>) query.getResultList();
            
            // I know this is extremely inefficient but this will do until I figure out how 
            // how the Java Persistance Query Language works
            for (User user : users)
                if (user.getEmail().equals(email) || user.getUsername().equals(username))
                    return false;
            
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
        
        User user = new User();

        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(hashedPassword);
        user.setPosition(position);

        em.persist(user);
        return true;
    }

    public List<UserDetails> getAllUsers() {
        LOG.info("UserBean:getAllUsers");

        try {
            Query query = em.createQuery("SELECT u FROM User u");
            List<User> users = (List<User>) query.getResultList();
            return copyUsersToDetails(users);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private List<UserDetails> copyUsersToDetails(List<User> users) {
        List<UserDetails> detailsList = new ArrayList<>();

        for (User user : users) {
            UserDetails userDetails = new UserDetails(user.getId(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getPosition());
            detailsList.add(userDetails);
        }

        return detailsList;
    }
}
