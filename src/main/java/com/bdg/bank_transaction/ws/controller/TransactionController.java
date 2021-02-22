package com.bdg.bank_transaction.ws.controller;

import com.bdg.bank_transaction.core.service.impl.TransactionServiceImpl;
import com.bdg.bank_transaction.infrastructure.entity.Transaction;
import com.bdg.bank_transaction.utils.enumaration.TransactionTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/trans")
public class TransactionController {
    private final TransactionServiceImpl transactionService;

    public TransactionController(TransactionServiceImpl transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable ("id") int id){
        return this.transactionService.getById(id);
    }

    @PostMapping()
    public Transaction addTransaction(@RequestBody Transaction transaction){
        return this.transactionService.addTransaction(transaction);
    }

    @PutMapping("/{id}/{type}")
    public Transaction acceptTransaction(@PathVariable int id,  @PathVariable TransactionTypes type){
         return this.transactionService.acceptTransaction(id,type);
    }

    @GetMapping()
    public Set<Transaction> getAll(){
        return this.transactionService.getAll();
    }

    @PutMapping("/{id}")
    public Transaction cancelTransaction (@PathVariable int id){
        return this.transactionService.cancelTransaction(id);
    }

}
