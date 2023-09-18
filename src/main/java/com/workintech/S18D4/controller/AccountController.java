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

import com.workintech.S18D4.entity.Account;
import com.workintech.S18D4.entity.Customer;
import com.workintech.S18D4.service.AccountService;
import com.workintech.S18D4.service.CustomerService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private AccountService accountService;
    private CustomerService customerService;

    @Autowired
    public AccountController(AccountService accountService, CustomerService customerService) {
        this.accountService = accountService;
        this.customerService = customerService;
    }

    @GetMapping("/")
    public List<Account> get() {
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable int id) {
        Account account = accountService.findById(id);
        return account;
    }

    @DeleteMapping("/{id}")
    public Account delete(@PathVariable int id) {
        Account account = getById(id);
        accountService.delete(account);
        return account;
    }

    @PostMapping("/{customerId}")
    public Account save(@RequestBody Account account, @PathVariable int customerId) {
        Customer customer = customerService.findById(customerId);
        customer.add(account);
        account.setCustomer(customer);
        return accountService.save(account);
    }

    @PutMapping("/{customerId}")
    public Account update(@RequestBody Account account, @PathVariable int customerId) {
        Customer customer = customerService.findById(customerId);
        Account foundAccount = null;
        for (Account account1 : customer.getAccountList()) {
            if (account1.getAccount_id() == account.getAccount_id()) {
                foundAccount = account1;
            }
        }
        if (foundAccount == null) {
            //
        }
        int index = customer.getAccountList().indexOf(foundAccount);
        customer.getAccountList().set(index, account);
        account.setCustomer(customer);
        return accountService.save(account);
    }
}