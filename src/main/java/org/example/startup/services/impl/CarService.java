package org.example.startup.services.impl;

import org.example.startup.dao.ICarDAO;
import org.example.startup.dao.implement.CarDAO;
import org.example.startup.entity.CarDTO;
import org.example.startup.services.ICarService;

import java.util.List;

public class CarService implements ICarService {
    private ICarDAO carDAO = new CarDAO();

    @Override
    public ServiceResponse<List<CarDTO>> getAllCars() {
        List<CarDTO> cars = carDAO.getAll();
        return new ServiceResponse<>(true, "Cars retrieved successfully.", cars);
    }
}
