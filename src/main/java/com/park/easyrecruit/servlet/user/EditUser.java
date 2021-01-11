/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.servlet.user;

import com.park.easyrecruit.common.UserDetails;
import com.park.easyrecruit.ejb.UserBean;
import com.park.easyrecruit.utility.Password;
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
@WebServlet(name = "EditUser", urlPatterns = {"/Users/Edit"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"ManageUsersRole"}))
public class EditUser extends HttpServlet {

    @Inject
    private UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Find the user in the DB by id and set it to an attribute
        int userId = Integer.parseInt(request.getParameter("id"));
        UserDetails user = userBean.findById(userId);
        request.setAttribute("editUser", user);

        request.getRequestDispatcher("/WEB-INF/pages/editUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer userId = Integer.parseInt(request.getParameter("edit_user_id"));
        String firstName = request.getParameter("edit_first_name");
        String lastName = request.getParameter("edit_last_name");
        String password = request.getParameter("edit_password");
        String phoneNumber = request.getParameter("edit_phone_number");
        String email = request.getParameter("edit_email");
        String position = request.getParameter("edit_position");
        
        // Check whether the password was changed or not
        if (password.equals("")) {
            userBean.updateUser(userId, firstName, lastName, email, phoneNumber, position);
        } else {
            String hashedPassword = Password.convertToSha256(password);
            userBean.updateUserWithPassword(userId, firstName, lastName, email, phoneNumber, hashedPassword, position);
        }

        response.sendRedirect(request.getContextPath() + "/Users");
    }

    @Override
    public String getServletInfo() {
        return "EasyRecruit:EditUser:servlet";
    }
}
