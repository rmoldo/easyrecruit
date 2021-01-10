/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.servlet.application;

import com.park.easyrecruit.common.PositionDetails;
import com.park.easyrecruit.ejb.ApplicationBean;
import com.park.easyrecruit.ejb.PositionBean;
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
 * @author andrei
 */
@WebServlet(name = "AddApplication", urlPatterns = {"/Applications/Add"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"ClientRole"}))
public class AddApplication extends HttpServlet {

    @Inject
    private PositionBean positionBean;
    @Inject
    private ApplicationBean applicationBean;

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

        Integer positionId;
        try {
            positionId = Integer.parseInt(request.getParameter("positionId"));
        } catch (NumberFormatException e) {
            response.setStatus(404);
            return;
        }
        
        if (applicationBean.get(positionId, request.getUserPrincipal().getName()) != null)
        {
            response.sendRedirect(request.getContextPath() + "/Applications/Edit?positionId=" + positionId);
            return;
        }

        PositionDetails position = positionBean.getPosition(positionId);
        if (position == null) {
            response.setStatus(404);
            return;
        }

        request.setAttribute("position", position);
        request.getRequestDispatcher("/WEB-INF/pages/addApplication.jsp").forward(request, response);
    }
}
