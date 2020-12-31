/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.servlet.position;

import com.park.easyrecruit.ejb.PositionBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Silvan
 */
@WebServlet(name = "AddPositionComment", urlPatterns = {"/Positions/AddComment"})
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
        String creatorUser = request.getParameter("creatorUser");
        String text = request.getParameter("text");
        /*String positionName = request.getParameter("positionName");
        Integer neededNumber = Integer.parseInt(request.getParameter("neededNumber"));
        String description = "<b>Department:</b> " + request.getParameter("department")
            + "<br/><b>Project:</b> " + request.getParameter("project")
            + "<br/><b>Requirements:</b> " + request.getParameter("requirements")
            + "<br/><b>Responsibilities:</b> " + request.getParameter("responsibilities");
        String creatorUserName = request.getParameter("creatorUserName");

        if(!positionBean.addPosition(positionName, description, neededNumber, creatorUserName)) {
            request.setAttribute("position_error_message", "Error adding position");
            request.getRequestDispatcher("/WEB-INF/pages/addPosition.jsp").forward(request, response);
        }
        else {
            request.setAttribute("position_status_message", "Your position has been added succesfully and was sent to General Director for review!");
            request.getRequestDispatcher("/WEB-INF/pages/addPosition.jsp").forward(request, response);
        }*/

       // response.sendRedirect(request.getContextPath());
    }

    @Override
    public String getServletInfo() {
        return "add position servlet";
    }

}
