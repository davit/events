package com.events.controller;

import com.events.beans.CityDaoLocal;
import com.events.model.City;
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


@WebServlet(name = "CityEdit", urlPatterns = {"/city/edit"})
public class CityEdit extends HttpServlet {
    
    @Inject CityDaoLocal cityDaoLocal;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String jsonStr = request.getParameter("cities");
        JsonReader jsonReader = Json.createReader(new StringReader(jsonStr));
        JsonArray jsonArray = jsonReader.readArray();
        
        for (int k = 0; k < jsonArray.size(); k++) {
            JsonObject jsonCity = jsonArray.getJsonObject(k);
            switch (jsonCity.getString("status")) {
                case "new":
                    {
                        City city = new City();
                        city.setCityName(jsonCity.getString("city"));
                        cityDaoLocal.create(city);
                        break;
                    }
                case "old":
                    {
                        City city = cityDaoLocal.get(new Integer(jsonCity.getInt("id")));
                        city.setCityName(jsonCity.getString("city"));
                        cityDaoLocal.update(city);
                        break;
                    }
            }
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
}
