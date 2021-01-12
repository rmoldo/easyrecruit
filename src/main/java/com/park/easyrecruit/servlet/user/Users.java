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
@WebServlet(name = "Users", urlPatterns = {"/Users"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"ManageUsersRole"}))
public class Users extends HttpServlet {

    @Inject
    private UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("activePage", "Users");

        List<UserDetails> users = userBean.getAllUsers();
        request.setAttribute("users", users);

        // Forward the extracted users to the UI
        request.getRequestDispatcher("/WEB-INF/pages/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Users servlet";
    }
}
