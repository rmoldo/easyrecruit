/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.servlet.position;

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
@WebServlet(name = "AddPosition", urlPatterns = {"/Positions/Add"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"ManagePositionsRole"}))
public class AddPosition extends HttpServlet {

    @Inject
    private PositionBean positionBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/addPosition.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

        if(!positionBean.addPosition(positionName, department, project, requirements, responsibilities, neededNumber, creatorUserName)) {
        	request.setAttribute("position_error_message", "Error adding position");
        	request.getRequestDispatcher("/WEB-INF/pages/addPosition.jsp").forward(request, response);
        }
        else {
        	request.setAttribute("position_status_message", "Your position has been added succesfully and was sent to General Director for review!");
        	request.getRequestDispatcher("/WEB-INF/pages/addPosition.jsp").forward(request, response);
        }

        response.sendRedirect(request.getContextPath());
    }

    @Override
    public String getServletInfo() {
        return "add position servlet";
    }

}
