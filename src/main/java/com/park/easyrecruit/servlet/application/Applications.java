/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.servlet.application;

import com.park.easyrecruit.ejb.ApplicationBean;
import java.io.IOException;
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
 * @author andrei
 */
@WebServlet(name = "Applications", urlPatterns = {"/Applications"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"ManageMyApplicationsRole"}))
public class Applications extends HttpServlet {

    @Inject
    private ApplicationBean applicationBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // anyone GET => applications of current user (My Applications)
        request.setAttribute("applications", applicationBean.getMany(request.getUserPrincipal().getName()));
        request.getRequestDispatcher("/WEB-INF/pages/applications.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = (String) request.getParameter("action");
        if(action != null) {
            applicationBean.executeAction(action,
                    Integer.parseInt((String) request.getParameter("positionId")),
                    (String) request.getParameter("username"));
        }
        
        request.setAttribute("applicationsAll", applicationBean.getAll());
        request.getRequestDispatcher("/WEB-INF/pages/applicationsListAll.jsp").forward(request, response);
    }
}
