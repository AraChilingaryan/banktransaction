package com.bdg.bank_transaction.core.service;

import com.bdg.bank_transaction.infrastructure.entity.Transaction;
import com.bdg.bank_transaction.utils.enumaration.TransactionTypes;

import java.util.Set;

public interface TransactionService {
    public Transaction addTransaction(Transaction transaction);
    public Transaction acceptTransaction(int transactionId, TransactionTypes transactionTypes);
    public Transaction cancelTransaction(int transactionId);
    public Set<Transaction> getAll();
    public Transaction getById(int id);
}
