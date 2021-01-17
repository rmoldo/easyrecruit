package com.park.easyrecruit.servlet.interview;

import com.park.easyrecruit.ejb.InterviewBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
 * @author Dragos
 */
@WebServlet(name = "Interview", urlPatterns = {"/Interview"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"ManageInterviewRole"}))
public class Interviews extends HttpServlet {
@Inject  
    private InterviewBean interviewBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Integer positionId;
        Integer candidateId;
        
        positionId = Integer.parseInt(request.getParameter("positionId"));
        candidateId = Integer.parseInt(request.getParameter("candidateId"));
        
        request.setAttribute("positionId", positionId);
        request.setAttribute("candidateId", candidateId);
        
        request.setAttribute("activePage", "Interview");
        request.getRequestDispatcher("/WEB-INF/pages/setInterview.jsp").forward(request, response);
           
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Integer positionId;
        Integer candidateId;
        
        positionId = Integer.parseInt(request.getParameter("positionId"));
        candidateId = Integer.parseInt(request.getParameter("candidateId"));
        
        String interviewer = request.getParameter("interviewer");
        String typeOfInterview = request.getParameter("typeOfInterview");
        String date = request.getParameter("date");
        String comment = request.getParameter("comment");    
        interviewBean.addInterview(date, interviewer, typeOfInterview, comment, positionId, candidateId);
        response.sendRedirect(request.getContextPath() + "/ApplicationsListAll");
        
        
    } 

   
}
