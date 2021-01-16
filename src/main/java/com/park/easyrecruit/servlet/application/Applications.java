/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.servlet.application;

import com.park.easyrecruit.ejb.ApplicationBean;
import com.park.easyrecruit.ejb.InterviewBean;
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
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"InterviewStatusRole"}))
public class Applications extends HttpServlet {

    @Inject
    private ApplicationBean applicationBean;
    
    @Inject  
    private InterviewBean interviewBean;
            
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // anyone GET => applications of current user (My Applications)
        // HR GET + positionId => list all applications for specified position
        
        request.setAttribute("applications", applicationBean.getMany(request.getUserPrincipal().getName()));
        request.getRequestDispatcher("/WEB-INF/pages/applications.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String interviewer = request.getParameter("interviewer");
        String typeOfInterview = request.getParameter("typeOfInterview");
        String date = request.getParameter("date");
        String comment = request.getParameter("comment");    
        interviewBean.addInterview(date, interviewer, typeOfInterview, comment);
        request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);

    } 
}
