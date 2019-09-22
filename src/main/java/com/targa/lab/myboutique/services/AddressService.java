package com.targa.lab.myboutique.services;

import com.targa.lab.myboutique.dto.AddressDto;
import com.targa.lab.myboutique.entities.Address;

public class AddressService {
    public static AddressDto mapToDto(Address address) {
        if (address != null) {
            return new AddressDto(address.getAddress1(),
                    address.getAddress2(),
                    address.getCity(),
                    address.getPostcode(),
                    address.getCountry()
            );
        }
        return null;
    }
}