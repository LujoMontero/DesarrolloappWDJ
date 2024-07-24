package org.example.startup.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.startup.dao.IUserRolService;
import org.example.startup.dao.implement.UserRolService;
import org.example.startup.entity.*;
import org.example.startup.services.*;
import org.example.startup.services.impl.*;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private IUserService userService = new UserService();
    private IAddressService addressService = new AddressService();
    private ICarService carService = new CarService();
    private IRolService rolService = new RolService();
    private IUserRolService userRolService = new UserRolService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String nick = request.getParameter("nick");
        int weight = Integer.parseInt(request.getParameter("weight"));
        int carId = Integer.parseInt(request.getParameter("carId"));
        int rolId = Integer.parseInt(request.getParameter("rolId"));
        int addressId = Integer.parseInt(request.getParameter("addressId"));

        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);
        userDTO.setPassword(password);
        userDTO.setName(name);
        userDTO.setNick(nick);
        userDTO.setWeight(weight);

        CarDTO carDTO = new CarDTO();
        carDTO.setId(carId);
        userDTO.setCar(carDTO);

        RolDTO rolDTO = new RolDTO();
        rolDTO.setId(rolId);
        userDTO.setRol(rolDTO);

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(addressId);
        userDTO.setAddress(addressDTO);

        ServiceResponse<UserDTO> result = userService.addUser(userDTO);

        if (result.isSuccess()) {
            UserRolDTO userRolDTO = new UserRolDTO();
            userRolDTO.setIdUser(result.getData().getId());
            userRolDTO.setIdRol(rolId);
            userRolService.add(userRolDTO);
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("errorMessage", result.getMessage());
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
