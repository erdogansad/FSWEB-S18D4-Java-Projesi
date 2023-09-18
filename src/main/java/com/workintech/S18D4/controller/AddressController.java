package com.workintech.S18D4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workintech.S18D4.entity.Address;
import com.workintech.S18D4.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
    private AddressService addressService;

@Autowired
    public AddressContoller(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/")
    public List<Address> get() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public Address getById(@PathVariable int id) {
        Address adress = addressService.findById(id);
        return adress;
    }

    @DeleteMapping("/{id}")
    public Address delete(@PathVariable int id) {
        Address adress = getById(id);
        addressService.delete(adress);
        return adress;
    }

    @PostMapping("/customers")
    public Address save(@RequestBody Address adress) {
        return addressService.save(adress);
    }

    @PutMapping("/{id}")
    public Address update(@RequestBody Address adress, @PathVariable int id) {
        Address foundAddress = getById(id);
        if (foundAddress != null) {
            adress.setId(id);
            return addressService.save(adress);

        }
        return null;
    }
}
