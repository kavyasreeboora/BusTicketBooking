package com.bus.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bus.util.DBConnection;

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
    	
    	response.setContentType("text/html");

        int busId =
                Integer.parseInt(request.getParameter("busId"));

        int seats =
                Integer.parseInt(request.getParameter("seats"));

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "select available_seats,fare from buses where bus_id=?");

            ps.setInt(1, busId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                int available =
                        rs.getInt("available_seats");

                double fare =
                        rs.getDouble("fare");

                if(available >= seats) {

                    double total = fare * seats;

                    HttpSession session =
                            request.getSession();

                    int userId =
                            (Integer)session.getAttribute("userId");

                    PreparedStatement book =
                            con.prepareStatement(
                                    "insert into bookings(user_id,bus_id,seats_booked,total_amount) values(?,?,?,?)");

                    book.setInt(1, userId);
                    book.setInt(2, busId);
                    book.setInt(3, seats);
                    book.setDouble(4, total);

                    book.executeUpdate();

                    PreparedStatement update =
                            con.prepareStatement(
                                    "update buses set available_seats=available_seats-? where bus_id=?");

                    update.setInt(1, seats);
                    update.setInt(2, busId);

                    update.executeUpdate();

                    response.sendRedirect("success.jsp");

                } else {

                    response.getWriter().println(
                            "Seats Not Available");
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
