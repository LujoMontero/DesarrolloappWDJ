package org.example.startup.dao.implement;

import org.example.startup.dao.IUserRolService;
import org.example.startup.entity.UserRolDTO;
import org.example.startup.services.impl.ServiceResponse;


public class UserRolService implements IUserRolService {
    private UserRolDAO userRolDAO = new UserRolDAO();

    @Override
    public ServiceResponse<UserRolDTO> add(UserRolDTO userRolDTO) {
        boolean success = userRolDAO.add(userRolDTO);
        if (success) {
            return new ServiceResponse<>(true, "User role added successfully", userRolDTO);
        } else {
            return new ServiceResponse<>(false, "Failed to add user role", null);
        }
    }
}
