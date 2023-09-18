package com.workintech.S18D4.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workintech.S18D4.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
