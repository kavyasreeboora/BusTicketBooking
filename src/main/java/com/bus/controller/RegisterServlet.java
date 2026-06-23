package com.bus.controller;

import java.io.IOException;

import com.bus.dao.UserDAO;
import com.bus.model.User;

import jakarta.servlet.RequestDispatcher;
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
User u=new User();
u.setName(name);
u.setEmail(email);
u.setPassword(password);
UserDAO ud=new UserDAO();
boolean b=ud.registerUser(u);
   if(b) {
	   response.sendRedirect("login.jsp");
   }
   else {
	   
	   response.sendRedirect("register.jsp");
        }
    }
}