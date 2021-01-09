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
@WebServlet(name = "DeletePosition", urlPatterns = {"/Positions/Delete"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"CeoRole"}))
public class DeletePosition extends HttpServlet {

    @Inject
    private PositionBean positionBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer positionId = Integer.parseInt(request.getParameter("positionId"));
        if(positionBean.deletePosition(positionId)) {
            request.setAttribute("delete_successfull", "Position deleted successfully!");
        }
        else {
            request.setAttribute("delete_successfull", "Failed to delete position!");
        }
        //should be replaced with forward to show messages, but second time link won't work, so keep it as this now
        response.sendRedirect(request.getContextPath()+ "/Positions");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    public String getServletInfo() {
        return "Servlet that deletes position";
    }
}
