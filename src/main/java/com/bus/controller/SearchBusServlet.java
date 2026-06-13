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

@WebServlet("/searchBus")
public class SearchBusServlet extends HttpServlet {
	
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

    	response.setContentType("text/html");
    	
        String source = request.getParameter("source");
        String destination = request.getParameter("destination");

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "select * from buses where source=? and destination=?");

            ps.setString(1, source);
            ps.setString(2, destination);

            ResultSet rs = ps.executeQuery();

            PrintWriter out = response.getWriter();

            out.println("<h2>Available Buses</h2>");

            while(rs.next()) {

                out.println("Bus ID : "
                        + rs.getInt("bus_id") + "<br>");

                out.println("Bus Name : "
                        + rs.getString("bus_name") + "<br>");

                out.println("Fare : "
                        + rs.getDouble("fare") + "<br>");

                out.println("Available Seats : "
                        + rs.getInt("available_seats") + "<br><br>");
            }

            out.println("<a href='booking.jsp'>Book Ticket</a>");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
