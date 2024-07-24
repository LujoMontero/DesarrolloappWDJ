package org.example.startup.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.startup.entity.UserDTO;
import org.example.startup.services.IUserService;
import org.example.startup.services.impl.ServiceResponse;

import org.example.startup.services.impl.UserService;

import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private IUserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        ServiceResponse<UserDTO> result = userService.userLogin(email, password);

        if (result.isSuccess()) {
            HttpSession session = request.getSession();
            session.setAttribute("user", result.getData());
            response.sendRedirect("dashboard.jsp");
        } else {
            request.setAttribute("errorMessage", result.getMessage());
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
