package org.example.startup.services.impl;

import org.example.startup.dao.ISuppliersDAO;
import org.example.startup.dao.implement.SuppliersDAO;
import org.example.startup.entity.SupplierDTO;
import org.example.startup.services.ISuppliersService;

import java.util.List;

public class SuppliersService implements ISuppliersService {
    private ISuppliersDAO suppliersDAO = new SuppliersDAO();

    @Override
    public ServiceResponse<List<SupplierDTO>> getAllSuppliers() {
        List<SupplierDTO> suppliers = suppliersDAO.getAll();
        return new ServiceResponse<>(true, "Suppliers retrieved successfully.", suppliers);
    }
}
