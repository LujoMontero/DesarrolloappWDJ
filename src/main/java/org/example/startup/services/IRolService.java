package org.example.startup.services;

import org.example.startup.entity.RolDTO;
import org.example.startup.services.impl.ServiceResponse;

import java.util.List;

public interface IRolService {
    ServiceResponse<List<RolDTO>> getAllRoles();
}