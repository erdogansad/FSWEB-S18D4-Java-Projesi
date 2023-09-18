package com.workintech.S18D4.service;

import java.util.List;

import com.workintech.S18D4.entity.Address;

public interface AddressService {
    List<Address> findAll();

    void delete(Address adress);

    Address findById(int id);

    Address save(Address adress);
}
