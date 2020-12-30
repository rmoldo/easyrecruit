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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author M Radu
 */
@WebServlet(name = "RegisterUser", urlPatterns = {"/Users/Register"})
public class RegisterUser extends HttpServlet {

    @Inject
    private UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phoneNumber = request.getParameter("phoneNumber");

        String hashedPassword = Password.convertToSha256(password);

        if (!userBean.createUser(username, email, hashedPassword, "CLIENT", firstName, lastName, phoneNumber)) {
            request.setAttribute("register_error_message", "User already exists");
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
        }

        response.sendRedirect(request.getContextPath());
    }

    @Override
    public String getServletInfo() {
        return "EasyRecruit:RegisterUser:servlet";
    }
}
