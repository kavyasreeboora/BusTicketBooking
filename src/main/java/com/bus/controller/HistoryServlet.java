package com.bus.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
    	
    	response.setContentType("text/html");

        try {

            HttpSession session =
                    request.getSession();

            int userId =
                    (Integer)session.getAttribute("userId");

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(
                            "select * from bookings where user_id=?");

            ps.setInt(1, userId);

            ResultSet rs =
                    ps.executeQuery();

            PrintWriter out =
                    response.getWriter();

            out.println("<h2>Booking History</h2>");

            while(rs.next()) {

                out.println("Booking ID : "
                        + rs.getInt("booking_id"));

                out.println("<br>Bus ID : "
                        + rs.getInt("bus_id"));

                out.println("<br>Seats : "
                        + rs.getInt("seats_booked"));

                out.println("<br>Amount : "
                        + rs.getDouble("total_amount"));

                out.println("<hr>");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
