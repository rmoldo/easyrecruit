/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.servlet.application;

import com.park.easyrecruit.ejb.ApplicationBean;
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
 * @author dragos
 */
@WebServlet(name = "ApplicationsListAll", urlPatterns = {"/ApplicationsListAll"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"ReadAllApplicationsRole"}))
public class ApplicationsListAll extends HttpServlet {

    @Inject
    private ApplicationBean applicationBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("applicationsAll", applicationBean.getAll());
        request.getRequestDispatcher("/WEB-INF/pages/applicationsListAll.jsp").forward(request, response);
    }
}
