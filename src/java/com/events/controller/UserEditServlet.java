package com.events.controller;

import com.events.beans.UsersDaoLocal;
import com.events.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "UserEditServlet", urlPatterns = {"/user/edit"})
public class UserEditServlet extends HttpServlet {
    
    @Inject UsersDaoLocal usersDaoLocal;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String jsonStr = request.getParameter("users");
        JsonReader jsonReader = Json.createReader(new StringReader(jsonStr));        
        JsonArray jsonArray = jsonReader.readArray();
        
        for (int k = 0; k < jsonArray.size(); k++) {
            JsonObject jsonUser = jsonArray.getJsonObject(k);            
            if (jsonUser.getString("status").equals("new")) {
                User user = new User();
                user.setUserName(jsonUser.getString("user"));
                user.setPassword(jsonUser.getString("password"));
                usersDaoLocal.create(user);
            }else if (jsonUser.getString("status").equals("old")) {                   
                User user = usersDaoLocal.get(new Integer(jsonUser.getInt("id")));                
                user.setUserName(jsonUser.getString("user"));
                usersDaoLocal.update(user);
            }
        }
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
    }
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
