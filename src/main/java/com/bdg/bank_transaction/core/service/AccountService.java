package com.bdg.bank_transaction.core.service;

import com.bdg.bank_transaction.infrastructure.entity.Account;

public interface AccountService {
    public Account addAccount(Account account);
    public Account getById(int id);
}
