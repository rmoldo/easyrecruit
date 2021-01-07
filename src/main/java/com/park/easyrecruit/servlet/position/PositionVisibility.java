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
@WebServlet(name = "PositionVisibility", urlPatterns = {"/Positions/Visibility"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"CeoRole"}))
public class PositionVisibility extends HttpServlet {

    @Inject
    private PositionBean positionBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer positionId = Integer.parseInt(request.getParameter("positionId"));
        String action = request.getParameter("action");
        
        if(action.equals("open")) {
            if(positionBean.openPosition(positionId)) {
                request.setAttribute("visibility_status", "Position opened successfully!");
            }
            else {
                request.setAttribute("visibility_error", "Failed to open position!");
            }
        }
        else if(action.equals("close")) {
            if(positionBean.closePosition(positionId)) {
                request.setAttribute("visibility_status", "Position closed successfully!");
            }
            else {
                request.setAttribute("visibility_error", "Failed to close position!");
            }
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
        return "Servlet that changes visibility of the position";
    }

}