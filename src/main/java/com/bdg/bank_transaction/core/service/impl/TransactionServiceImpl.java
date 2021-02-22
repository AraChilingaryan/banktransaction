package com.bdg.bank_transaction.core.service.impl;

import com.bdg.bank_transaction.core.service.TransactionService;
import com.bdg.bank_transaction.infrastructure.entity.Account;
import com.bdg.bank_transaction.infrastructure.entity.Transaction;
import com.bdg.bank_transaction.infrastructure.repository.AccountRepository;
import com.bdg.bank_transaction.infrastructure.repository.TransactionRepository;
import com.bdg.bank_transaction.utils.enumaration.Status;
import com.bdg.bank_transaction.utils.enumaration.TransactionTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }


    @Override
    public Transaction addTransaction(Transaction transaction) {
        transaction.setStatus(Status.PENDING);
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction acceptTransaction(int transactionId, TransactionTypes transactionTypes) {
        Transaction transaction = this.transactionRepository.findById(transactionId).get();
        transaction.setStatus(Status.ACCEPTED);
        Account account = this.accountRepository.findById(transaction.getAccounts().getId()).get();
        if (transactionTypes == TransactionTypes.DEPOSIT) {
            account.setBalance(account.getBalance() + transaction.getSum());
        } else if (transactionTypes == TransactionTypes.WITHDRAWAL) {
            account.setBalance(account.getBalance() - transaction.getSum());
        }
        this.accountRepository.save(account);
        return this.transactionRepository.save(transaction);
    }

    @Override
    public Transaction cancelTransaction(int transactionId) {
        this.transactionRepository.findById(transactionId).map(transaction -> {
            transaction.setStatus(Status.CANCELED);
            return transactionRepository.save(transaction);
        });
        return  this.transactionRepository.findById(transactionId).get();
    }

    @Override
    public Set<Transaction> getAll() {
        return this.transactionRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Transaction getById(int id) {
        return this.transactionRepository.findById(id).get();
    }


}
