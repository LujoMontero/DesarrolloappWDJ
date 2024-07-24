package org.example.startup.services;

import org.example.startup.entity.CarDTO;
import org.example.startup.services.impl.ServiceResponse;

import java.util.List;

public interface ICarService {
    ServiceResponse<List<CarDTO>> getAllCars();
}
