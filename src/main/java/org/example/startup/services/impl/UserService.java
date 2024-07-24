package org.example.startup.services.impl;

import org.example.startup.dao.IUserDAO;
import org.example.startup.dao.implement.UserDAO;
import org.example.startup.entity.UserDTO;
import org.example.startup.services.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private IUserDAO userDAO = new UserDAO();

    @Override
    public ServiceResponse<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userDAO.getAll();
        return new ServiceResponse<>(true, "Users retrieved successfully.", users);
    }

    @Override
    public ServiceResponse<UserDTO> addUser(UserDTO dto) {
        UserDTO newUser = userDAO.add(dto);

        if (newUser.getId() > 0) {
            return new ServiceResponse<>(true, "User added successfully.", newUser);
        } else {
            return new ServiceResponse<>(false, "Failed to add user.");
        }
    }

    @Override
    public ServiceResponse<Boolean> emailExists(String email) {
        boolean exists = userDAO.emailExists(email);
        return new ServiceResponse<>(true, "Email check completed.", exists);
    }

    @Override
    public ServiceResponse<UserDTO> userLogin(String email, String password) {
        UserDTO user = userDAO.userLogin(email, password);

        if (user != null) {
            return new ServiceResponse<>(true, "Login successful.", user);
        } else {
            return new ServiceResponse<>(false, "Invalid email or password.");
        }
    }
}
