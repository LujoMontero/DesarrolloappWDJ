package org.example.startup.dao;

import org.example.startup.entity.RolDTO;

import java.util.List;

public interface IRolDAO {
    List<RolDTO> getAll();
}