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
@WebServlet(name = "AddPositionComment", urlPatterns = {"/Positions/AddComment"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"AdminRole", "CeoRole", "ClientRole"}))
public class AddPositionComment extends HttpServlet {

    @Inject
    private PositionBean positionBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/positions.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer positionId = Integer.parseInt(request.getParameter("positionId"));
        String creatorUser = request.getParameter("creatorUser");
        String text = request.getParameter("text");


        if(positionBean.addComment(positionId, creatorUser, text)) {
            response.sendRedirect(request.getContextPath()+ "/Positions");
        }
        else {
            request.setAttribute("comment_error", "We encounted an error while adding your comment!");
            request.getRequestDispatcher("/WEB-INF/pages/positions.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "add position servlet";
    }

}
