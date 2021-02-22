package com.bdg.bank_transaction.ws.controller;

import com.bdg.bank_transaction.core.service.impl.AccountServiceImpl;
import com.bdg.bank_transaction.infrastructure.entity.Account;
import com.bdg.bank_transaction.infrastructure.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountServiceImpl accountService;

    public AccountController(AccountServiceImpl accountService){
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable ("id") int id){
        return this.accountService.getById(id);

    }

    @PostMapping()
    public ResponseEntity<Account> addAccount(@RequestBody Account account){
       Account account1 =   this.accountService.addAccount(account);
        return new ResponseEntity<>(account1, HttpStatus.CREATED);
    }
}
