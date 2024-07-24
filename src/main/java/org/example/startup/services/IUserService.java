package org.example.startup.services;

import org.example.startup.entity.UserDTO;
import org.example.startup.services.impl.ServiceResponse;

import java.util.List;

public interface IUserService {
    ServiceResponse<List<UserDTO>> getAllUsers();
    ServiceResponse<UserDTO> addUser(UserDTO dto);
    ServiceResponse<Boolean> emailExists(String email);
    ServiceResponse<UserDTO> userLogin(String email, String password);
}
