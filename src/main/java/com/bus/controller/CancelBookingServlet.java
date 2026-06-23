package com.bus.controller;

import java.io.IOException;

import com.bus.dao.BookingDAO;
import com.bus.dao.BusDAO;
import com.bus.model.Booking;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cancelBooking")
public class CancelBookingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        int bookingId =
                Integer.parseInt(
                request.getParameter("bookingId"));

        BookingDAO bookingDao =
                new BookingDAO();

        Booking booking =
                bookingDao.getBookingById(bookingId);

        if(booking != null) {

            BusDAO busDao =
                    new BusDAO();

            busDao.increaseSeats(
                    booking.getBusId(),
                    booking.getSeatsBooked());

            bookingDao.cancelBooking(bookingId);
        }

        response.sendRedirect("history");
    }
}