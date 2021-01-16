package com.park.easyrecruit.servlet.interview;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dragos
 */
@WebServlet(name = "Interview", urlPatterns = {"/Interview"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"ManageInterviewRole"}))
public class Interviews extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("activePage", "Interview");
        request.getRequestDispatcher("/WEB-INF/pages/setInterview.jsp").forward(request, response);
           
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        String date = request.getParameter("date");
        String interviewer = request.getParameter("interviewer");
        String typeOfInterview = request.getParameter("typeOfInterview");
        String comment = request.getParameter("comment");
        
        response.sendRedirect(request.getContextPath());
    }

   
}
