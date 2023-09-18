package com.workintech.S18D4.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workintech.S18D4.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
