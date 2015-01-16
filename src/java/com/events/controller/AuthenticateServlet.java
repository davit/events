package com.events.controller;

import com.events.beans.UsersDaoLocal;
import com.events.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "AuthenticateServlet", urlPatterns = {"/authenticate"})
public class AuthenticateServlet extends HttpServlet {
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Inject UsersDaoLocal usersDaoLocal;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String userName = request.getParameter("uname");
        String password = request.getParameter("password");
        
        User user = usersDaoLocal.getByUserAndPassword(userName, password);
        
        if (user != null) {
            request.getSession().setAttribute("user", user);
            request.getSession().setMaxInactiveInterval(60); 
            response.sendRedirect("events");

        }else {
            request.setAttribute("errorMessage", "Uknown user, please try again");
            request.getRequestDispatcher("login").forward(request, response);
        }
        
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
