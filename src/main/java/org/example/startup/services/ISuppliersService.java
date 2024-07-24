package org.example.startup.services;

import org.example.startup.entity.SupplierDTO;
import org.example.startup.services.impl.ServiceResponse;

import java.util.List;

public interface ISuppliersService {
    ServiceResponse<List<SupplierDTO>> getAllSuppliers();
}
