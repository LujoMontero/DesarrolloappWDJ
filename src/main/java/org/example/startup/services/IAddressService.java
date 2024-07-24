package org.example.startup.services;

import org.example.startup.entity.AddressDTO;
import org.example.startup.services.impl.ServiceResponse;

public interface IAddressService {
    ServiceResponse<AddressDTO> addAddress(AddressDTO addressDTO);
}
