package com.park.easyrecruit.servlet.interview;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dragos
 */
@WebServlet(name = "Interview", urlPatterns = {"/Interview"})
public class Interview extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("activePage", "Products");
        request.getRequestDispatcher("/WEB-INF/pages/setInterview.jsp").forward(request, response);
    }
}
