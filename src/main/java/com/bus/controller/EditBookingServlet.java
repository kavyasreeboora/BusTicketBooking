package com.bus.controller;

import java.io.IOException;

import com.bus.dao.BookingDAO;
import com.bus.dao.BusDAO;
import com.bus.model.Booking;
import com.bus.model.Bus;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editBooking")
public class EditBookingServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        int bookingId =
            Integer.parseInt(
            request.getParameter("bookingId"));

        int seats =
            Integer.parseInt(
            request.getParameter("seats"));

        BookingDAO bookingDao =
                new BookingDAO();

        Booking booking =
                bookingDao.getBookingById(bookingId);

        BusDAO busDao =
                new BusDAO();

        Bus bus =
                busDao.getBusById(
                booking.getBusId());

        double totalAmount =
                bus.getFare() * seats;

        bookingDao.updateBooking(
                bookingId,
                seats,
                totalAmount);

        response.sendRedirect("history");
    }
}