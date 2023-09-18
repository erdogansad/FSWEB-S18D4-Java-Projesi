package com.workintech.S18D4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workintech.S18D4.dao.AddressRepository;
import com.workintech.S18D4.entity.Address;

@Service
public class AddressImpl implements AddressService {
    private AddressRepository addressRepository;

    @Autowired

    public AddressImpl(AddressRepository adressRepository) {
        this.addressRepository = adressRepository;
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public void delete(Address adress) {
        addressRepository.delete(adress);

    }

    @Override
    public Address findById(int id) {
        Optional<Address> optionalAdress = addressRepository.findById(id);
        if (optionalAdress.isPresent()) {
            return optionalAdress.get();
        }
        return null;
    }

    @Override
    public Address save(Address adress) {
        return addressRepository.save(adress);
    }
}
