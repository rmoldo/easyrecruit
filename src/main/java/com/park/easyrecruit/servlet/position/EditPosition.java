/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.servlet.position;

import com.park.easyrecruit.common.PositionDetails;
import com.park.easyrecruit.ejb.PositionBean;
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
 * @author Silvan
 */
@WebServlet(name = "EditPosition", urlPatterns = {"/Positions/Edit"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"CeoRole"}))
public class EditPosition extends HttpServlet {

   @Inject
    private PositionBean positionBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer positionId = Integer.parseInt(request.getParameter("positionId"));
        PositionDetails position = positionBean.getPosition(positionId);
        request.setAttribute("position", position);

        //Forward position to UI
        request.getRequestDispatcher("/WEB-INF/pages/editPosition.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Integer positionId = Integer.parseInt(request.getParameter("positionId"));
        String positionName = request.getParameter("positionName");
        Integer neededNumber = Integer.parseInt(request.getParameter("neededNumber"));
        String department = request.getParameter("department");
        String project = "";
        if (request.getParameter("project") != null) {
            project = request.getParameter("project");
        }
        String requirements = request.getParameter("requirements");
        String responsibilities = request.getParameter("responsibilities");
        String creatorUserName = request.getParameter("creatorUserName");

        if(!positionBean.editPosition(positionId, positionName, department, project, requirements, responsibilities, neededNumber, creatorUserName)) {
        	request.setAttribute("position_error_message", "Error editing position");
        }
        else {
        	request.setAttribute("position_status_message", "Position saved succesfully! Geneal Director has to approve changes.");
        }
        //should be replaced with forward to show messages, but because of dependencies keep it as this now
        response.sendRedirect(request.getContextPath()+ "/Positions");
    }


    @Override
    public String getServletInfo() {
        return "Servlet that edits position";
    }
}
