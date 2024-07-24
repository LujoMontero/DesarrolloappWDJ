package org.example.startup.dao;

import org.example.startup.entity.CarDTO;

import java.util.List;

public interface ICarDAO {
    List<CarDTO> getAll();
}
