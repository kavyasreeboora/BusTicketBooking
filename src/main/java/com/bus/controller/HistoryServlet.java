package com.bus.controller;

import java.io.IOException;
import java.util.List;

import com.bus.dao.BookingDAO;
import com.bus.model.Booking;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

    	HttpSession session =
    	        request.getSession();

    	Integer userId =
    	        (Integer) session.getAttribute("userId");

    	if(userId == null) {
    	    response.sendRedirect("login.jsp");
    	    return;
    	}

        BookingDAO dao =
                new BookingDAO();

        List<Booking> history =
                dao.getBookingHistory(userId);

        request.setAttribute("history", history);

        RequestDispatcher rd =
                request.getRequestDispatcher("history.jsp");

        rd.forward(request, response);
    }
}