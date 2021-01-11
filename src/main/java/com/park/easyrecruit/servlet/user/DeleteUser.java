/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.servlet.user;

import com.park.easyrecruit.common.UserDetails;
import com.park.easyrecruit.ejb.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author M Radu
 */
@WebServlet(name = "DeleteUser", urlPatterns = {"/Users/Delete"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"ManageUsersRole"}))
public class DeleteUser extends HttpServlet {

    @Inject
    private UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<UserDetails> users = userBean.getAllUsers();
        request.setAttribute("listDeleteUsers", users);

        request.getRequestDispatcher("/WEB-INF/pages/deleteUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] userIds = request.getParameterValues("user_ids");

        if (userIds != null) {
            List<Integer> ids = new ArrayList<>();
            
            // Convert ids to integer
            for (String id : userIds) {
                ids.add(Integer.parseInt(id));
            }
            
            // Delete users by their ids
            userBean.deleteUsers(ids);
        }

        response.sendRedirect(request.getContextPath() + "/Users/Delete");
    }

    @Override
    public String getServletInfo() {
        return "EasyRecruit:DeleteUser:servlet";
    }
}
