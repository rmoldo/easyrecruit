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

    public UserDetails findById(Integer userId) {
        LOG.info("UserBean:findById");

        User user = em.find(User.class, userId);
        return new UserDetails(user.getId(), user.getUsername(), user.getEmail(), user.getPosition(), user.getFirstName(), user.getLastName(), user.getPhoneNumber());
    }

    public UserDetails findByUsername(String username) {
        LOG.info("UserBean:findById");

        try {
            User user = em
                    .createQuery("SELECT u FROM User u WHERE u.username = ?1", User.class)
                    .setParameter(1, username)
                    .getSingleResult();
            return new UserDetails(user.getId(), user.getUsername(), user.getEmail(), user.getPosition(), user.getFirstName(), user.getLastName(), user.getPhoneNumber());
        } catch (Exception e) {
            return null;
        }
    }

    public boolean createUser(String username, String email, String hashedPassword, String position, String firstName, String lastName, String phoneNumber) {
        LOG.info("UserBean:createUser");

        // Check if username or email is in the User database
        try {
            List<User> users = (List<User>) em.createQuery("SELECT u FROM User u WHERE u.username = :uname or u.email = :mail")
                    .setParameter("uname", username)
                    .setParameter("mail", email)
                    .getResultList();

            if (users.size() != 0) {
                return false;
            }
        } catch (Exception e) {
            throw new EJBException(e);
        }

        User user = new User();

        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(hashedPassword);
        user.setPosition(position);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhoneNumber(phoneNumber);

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
        LOG.info("UserBean:copyUsersToDetails");

        List<UserDetails> detailsList = new ArrayList<>();

        for (User user : users) {
            UserDetails userDetails = new UserDetails(user.getId(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getPosition(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getPhoneNumber());
            detailsList.add(userDetails);
        }

        return detailsList;
    }

    public void updateUser(Integer userId, String firstName, String lastName, String email, String phoneNumber, String position) {
        LOG.info("UserBean:updateUser");

        User user = em.find(User.class, userId);

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setPosition(position);
    }

    public void updateUserWithPassword(Integer userId, String firstName, String lastName, String email, String phoneNumber, String hashedPassword, String position) {
        LOG.info("UserBean:updateUserWithPassword");

        User user = em.find(User.class, userId);

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(hashedPassword);
        user.setPosition(position);
    }

    public boolean deleteUsers(List<Integer> ids) {
        LOG.info("UserBean:deleteUserByIds");

        boolean openApplication = false;

        for (Integer id : ids) {
            User user = em.find(User.class, id);

            if (user.getApplications().size() > 0) {
                openApplication = true;
                continue;
            }

            em.remove(user);
        }

        if (openApplication) {
            return false;
        }

        return true;
    }

    public void deleteUser(Integer userId) {
        LOG.info("UserBean:deleteUserByIds");

        User user = em.find(User.class, userId);

        em.remove(user);
    }
}
