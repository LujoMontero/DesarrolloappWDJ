package org.example.startup.services.impl;

import org.example.startup.dao.IAddressDAO;
import org.example.startup.dao.implement.AddressDAO;
import org.example.startup.entity.AddressDTO;
import org.example.startup.services.IAddressService;

public class AddressService implements IAddressService {
    private IAddressDAO addressDAO = new AddressDAO();

    @Override
    public ServiceResponse<AddressDTO> addAddress(AddressDTO addressDTO) {
        AddressDTO newAddress = addressDAO.add(addressDTO);

        if (newAddress.getId() > 0) {
            return new ServiceResponse<>(true, "Address added successfully.", newAddress);
        } else {
            return new ServiceResponse<>(false, "Failed to add address.");
        }
    }
}
