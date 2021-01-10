/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.servlet.application;

import com.park.easyrecruit.common.ApplicationDetails;
import com.park.easyrecruit.common.PositionDetails;
import com.park.easyrecruit.ejb.ApplicationBean;
import com.park.easyrecruit.ejb.PositionBean;
import com.park.easyrecruit.ejb.UserBean;
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
@WebServlet(name = "Application", urlPatterns = {"/Application"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"ClientRole" /* ... */}))
public class Application extends HttpServlet {

    @Inject
    private PositionBean positionBean;
    @Inject
    private ApplicationBean applicationBean;
    @Inject
    private UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // anyone GET + positionId => read application for current user, or create if not exists
        // HR GET + positionId + candidateId => read application for specified user
        Integer positionId;
        Integer candidateId = null;

        try {
            positionId = Integer.parseInt(request.getParameter("positionId"));

            String candidateIdStr = request.getParameter("candidateId");
            if (candidateIdStr != null) {
                candidateId = Integer.parseInt(candidateIdStr);
            }
        } catch (NumberFormatException e) {
            response.setStatus(404);
            return;
        }

        ApplicationDetails application = null;

        // TODO andrei: fix role check
        if (candidateId != null && request.isUserInRole("HR")) {
            application = applicationBean.get(positionId, candidateId);
            if (application == null) {
                response.setStatus(404);
                return;
            }

            request.setAttribute("comments", true);
        } else if (candidateId == null) {
            // application for current user

            String username = request.getUserPrincipal().getName();
            application = applicationBean.get(positionId, username);
            if (application == null) {
                PositionDetails position = positionBean.getPosition(positionId);
                if (position == null) {
                    response.setStatus(404);
                    return;
                }
                application = new ApplicationDetails();
                application.setPosition(position);
                application.setCandidate(userBean.findByUsername(username));
                application.setCvLink("");
            }
            request.setAttribute("edit", true);
        }

        request.setAttribute("application", application);
        request.getRequestDispatcher("/WEB-INF/pages/application.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer positionId;
        try {
            positionId = Integer.parseInt(request.getParameter("positionId"));
        } catch (NumberFormatException e) {
            response.setStatus(404);
            return;
        }

        ApplicationDetails ad = new ApplicationDetails();
        ad.setCvLink(request.getParameter("cvLink"));

        applicationBean.save(positionId, request.getUserPrincipal().getName(), ad);

        response.sendRedirect(request.getContextPath() + "/Applications");
    }
}
