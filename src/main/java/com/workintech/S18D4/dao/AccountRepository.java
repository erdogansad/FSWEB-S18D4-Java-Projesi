package com.workintech.S18D4.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workintech.S18D4.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
