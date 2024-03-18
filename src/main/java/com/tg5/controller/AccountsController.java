package com.tg5.controller;

import com.tg5.domain.Account;
import com.tg5.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountsController {
    @Autowired
    private AccountRepository accountRepository;

    // TODO accounts CRUD
    // Create (POST)
    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }
    // Read (GET)
    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    // Update (PUT)
    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable Long id, @RequestBody Account updatedAccount) {
        updatedAccount.setId(id); // Ensure the ID matches the path variable
        return accountRepository.save(updatedAccount);
    }

    // Delete (DELETE)
    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountRepository.deleteById(id);
    }

    // TODO [advanced] calculate attendance GET /members/{memberId}/attendance
    // TODO [advanced] accountance for a particulat account type (over all events) for a date range
    //    GET /accounts/{accountId}/attendance/2020-01-01/2020-12-31
}
