package com.workintech.S18D4.service;

import java.util.List;

import com.workintech.S18D4.entity.Account;

public interface AccountService {
    List<Account> findAll();

    void delete(Account account);

    Account findById(int id);

    Account save(Account account);
}
