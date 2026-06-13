package com.bus.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bus.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "insert into users(name,email,password) values(?,?,?)");

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);

            int result = ps.executeUpdate();

            if(result > 0) {
                response.sendRedirect("login.jsp");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}