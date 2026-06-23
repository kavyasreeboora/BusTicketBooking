package com.bus.controller;

import java.io.IOException;

import com.bus.dao.UserDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO dao = new UserDAO();

        boolean status = dao.login(email, password);

        if(status) {

            HttpSession session = request.getSession();

            session.setAttribute(
                    "userId",
                    dao.getUserId(email, password));

            response.sendRedirect("search.jsp");
        }
        else {

            RequestDispatcher rd =
                    request.getRequestDispatcher("login.jsp");

            rd.forward(request, response);
        }
    }
}