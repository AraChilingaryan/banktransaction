package com.bdg.bank_transaction.core.service.impl;

import com.bdg.bank_transaction.core.service.AccountService;
import com.bdg.bank_transaction.infrastructure.entity.Account;
import com.bdg.bank_transaction.infrastructure.entity.User;
import com.bdg.bank_transaction.infrastructure.repository.AccountRepository;
import com.bdg.bank_transaction.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Override
    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getById(int id) {
        return this.accountRepository.findById(id).get();
    }
}
