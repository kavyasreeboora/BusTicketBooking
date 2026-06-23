package com.bus.controller;

import java.io.IOException;

import com.bus.dao.BookingDAO;
import com.bus.dao.BusDAO;
import com.bus.model.Booking;
import com.bus.model.Bus;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/bookTicket")
public class BookingServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Integer userId =
                (Integer) session.getAttribute("userId");

        if(userId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String busIdStr = request.getParameter("busId");
        String seatsStr = request.getParameter("seats");

        // Debugging
        System.out.println("Bus ID = " + busIdStr);
        System.out.println("Seats = " + seatsStr);

        if(busIdStr == null || busIdStr.trim().isEmpty() ||
           seatsStr == null || seatsStr.trim().isEmpty()) {

            response.sendRedirect("booking.jsp");
            return;
        }

        int busId = Integer.parseInt(busIdStr);
        int seats = Integer.parseInt(seatsStr);

        Booking booking = new Booking();

        booking.setUserId(userId);
        booking.setBusId(busId);
        booking.setSeatsBooked(seats);

        // Temporary
        BusDAO busDao = new BusDAO();

        Bus bus = busDao.getBusById(busId);

        double totalAmount = bus.getFare() * seats;

        booking.setTotalAmount(totalAmount);
        BookingDAO dao = new BookingDAO();

        boolean status = dao.bookTicket(booking);

        if(status) {

            busDao.updateSeats(busId, seats);

            response.sendRedirect("success.jsp");

        } else {

            response.sendRedirect("booking.jsp");
        }
    }
}