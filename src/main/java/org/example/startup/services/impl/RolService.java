package org.example.startup.services.impl;

import org.example.startup.dao.IRolDAO;
import org.example.startup.dao.implement.RolDAO;
import org.example.startup.entity.RolDTO;
import org.example.startup.services.IRolService;

import java.util.List;

public class RolService implements IRolService {
    private IRolDAO rolDAO = new RolDAO();

    @Override
    public ServiceResponse<List<RolDTO>> getAllRoles() {
        List<RolDTO> roles = rolDAO.getAll();
        return new ServiceResponse<>(true, "Roles retrieved successfully.", roles);
    }
}
