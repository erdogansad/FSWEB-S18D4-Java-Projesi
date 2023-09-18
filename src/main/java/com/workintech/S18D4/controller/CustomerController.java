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

import com.workintech.S18D4.entity.Customer;
import com.workintech.S18D4.service.CustomerService;

@RestController
@RequestMapping("/customers")

public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public List<Customer> get() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable int id) {
        Customer customer = customerService.findById(id);
        return customer;
    }

    @DeleteMapping("/{id}")
    public Customer delete(@PathVariable int id) {
        Customer customer = getById(id);
        customerService.delete(customer);
        return customer;
    }

    @PostMapping("/customers")
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @PutMapping("/{id}")
    public Customer update(@RequestBody Customer customer, @PathVariable int id) {
        Customer foundCustomer = customerService.findById(id);
        if (foundCustomer != null) {
            customer.setId(id);
            return customerService.save(customer);
        }
        return null;
    }
}