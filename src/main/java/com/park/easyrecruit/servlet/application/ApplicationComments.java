/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.servlet.application;

import com.park.easyrecruit.common.*;
import com.park.easyrecruit.ejb.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 *
 * @author andrei
 */
@WebServlet(name = "ApplicationComments", urlPatterns = {"/ApplicationComments"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"ManageCommentsRole"}))
public class ApplicationComments extends HttpServlet {

    @Inject
    private ApplicationBean applicationBean;

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");
        if (idStr == null) {
            response.setStatus(400);
            return;
        }

        boolean deleted = applicationBean.deleteComment(
                Integer.parseInt(idStr),
                request.getUserPrincipal().getName());
        response.setStatus(deleted ? 204 : 400);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ApplicationCommentDetails acd = new ApplicationCommentDetails();
        acd.setText(request.getParameter("text"));

        String idStr = request.getParameter("id");
        String positionIdStr = request.getParameter("positionId");
        String candidateIdStr = request.getParameter("candidateId");

        if (idStr != null) {
            // UPDATE
            acd = applicationBean.updateComment(
                    Integer.parseInt(idStr),
                    request.getUserPrincipal().getName(),
                    acd);
        } else if (positionIdStr != null && candidateIdStr != null) {
            // CREATE
            acd = applicationBean.createComment(
                    Integer.parseInt(positionIdStr),
                    Integer.parseInt(candidateIdStr),
                    request.getUserPrincipal().getName(),
                    acd);
        } else {
            // BAD REQUEST
            response.setStatus(400);
            return;
        }

        if (acd == null) {
            response.setStatus(404);
            return;
        }
        
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(acd.toJsonString());
        out.flush();
    }
}
