package org.example.startup.dao;

import org.example.startup.entity.UserDTO;

import java.util.List;

public interface IUserDAO {
    List<UserDTO> getAll();
    UserDTO add(UserDTO dto);
    boolean emailExists(String email);
    UserDTO userLogin(String email, String password);
}