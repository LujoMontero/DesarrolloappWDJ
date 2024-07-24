package org.example.startup.dao;

import org.example.startup.entity.SupplierDTO;

import java.util.List;

public interface ISuppliersDAO {
    List<SupplierDTO> getAll();
}