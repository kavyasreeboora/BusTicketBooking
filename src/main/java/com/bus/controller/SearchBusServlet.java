package com.bus.controller;

import java.io.IOException;
import java.util.List;

import com.bus.dao.BusDAO;
import com.bus.model.Bus;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchBus")
public class SearchBusServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String source = request.getParameter("source");
        String destination = request.getParameter("destination");

        BusDAO dao = new BusDAO();

        List<Bus> busList =
                dao.searchBus(source, destination);

        request.setAttribute("busList", busList);

        request.getRequestDispatcher("searchResult.jsp")
        .forward(request, response);
    }
}