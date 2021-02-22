package com.bdg.bank_transaction.core.service;

import com.bdg.bank_transaction.infrastructure.entity.User;

public interface UserService {
    User register(User user);
    User changeRole(int id,int role);
    User getById(int id);
}
