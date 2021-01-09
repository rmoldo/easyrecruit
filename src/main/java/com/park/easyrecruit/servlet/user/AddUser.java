/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.servlet.user;

import com.park.easyrecruit.ejb.UserBean;
import com.park.easyrecruit.utility.Password;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AddUser", urlPatterns = {"/Users/Add"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"AdminRole", "CeoRole"}))
public class AddUser extends HttpServlet {
    
    @Inject
    private UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward the request to the addUser jsp page
        request.getRequestDispatcher("/WEB-INF/pages/addUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the values of the addUser form fields
        String username = request.getParameter("addUsername");
        String email = request.getParameter("addEmail");
        String password = request.getParameter("addPassword");
        String firstName = request.getParameter("addFirstName");
        String lastName = request.getParameter("addLastName");
        String phoneNumber = request.getParameter("addPhoneNumber");

        String hashedPassword = Password.convertToSha256(password);

        if (!userBean.createUser(username, email, hashedPassword, "CLIENT", firstName, lastName, phoneNumber)) {
            request.setAttribute("add_user_error_message", "User already exists with these credentials");
            request.getRequestDispatcher("/WEB-INF/pages/addUser.jsp").forward(request, response);
        }
        
        // Redirect to the list users page
        response.sendRedirect(request.getContextPath() + "/Users");
    }

    @Override
    public String getServletInfo() {
        return "EasyRecruit:AddUser:servlet";
    }
}
