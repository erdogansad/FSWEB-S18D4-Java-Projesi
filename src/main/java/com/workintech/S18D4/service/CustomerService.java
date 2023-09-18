package com.workintech.S18D4.service;

import java.util.List;

import com.workintech.S18D4.entity.Customer;

public interface CustomerService {
    List<Customer> findAll();

    void delete(Customer customer);

    Customer findById(int id);

    Customer save(Customer customer);
}
