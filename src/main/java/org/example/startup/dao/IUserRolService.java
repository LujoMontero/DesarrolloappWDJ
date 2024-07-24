package org.example.startup.dao;


import org.example.startup.entity.UserRolDTO;
import org.example.startup.services.impl.ServiceResponse;


public interface IUserRolService {
    ServiceResponse<UserRolDTO> add(UserRolDTO userRolDTO);
}
