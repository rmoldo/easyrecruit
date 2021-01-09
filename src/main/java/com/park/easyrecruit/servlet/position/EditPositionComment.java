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
@WebServlet(name = "EditPositionComment", urlPatterns = {"/Positions/EditComment"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"AdminRole", "CeoRole", "ClientRole"}))
public class EditPositionComment extends HttpServlet {

    @Inject
    private PositionBean positionBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer positionId = Integer.parseInt(request.getParameter("positionId"));
        Integer commentId = Integer.parseInt(request.getParameter("commentId"));
        String commentText = positionBean.getCommentText(positionId, commentId);
        request.setAttribute("commentText", commentText);
        request.setAttribute("positionId", positionId);
        request.setAttribute("commentId", commentId);

        request.getRequestDispatcher("/WEB-INF/pages/editComment.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Integer positionId = Integer.parseInt(request.getParameter("positionId"));
        Integer commentId = Integer.parseInt(request.getParameter("commentId"));
        String text = request.getParameter("text");
        

        if(!positionBean.editComment(positionId, commentId, text)) {
        	request.setAttribute("commentmessage", "Comment edited succesfully");
        }
        else {
        	request.setAttribute("commentmessage", "Comment could not be edited");
        }
        
        response.sendRedirect(request.getContextPath()+ "/Positions");
    }


    @Override
    public String getServletInfo() {
        return "Servlet that edits position comment";
    }
}
