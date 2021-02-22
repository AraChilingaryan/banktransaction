package com.bdg.bank_transaction.core.service.impl;

import com.bdg.bank_transaction.core.service.UserService;
import com.bdg.bank_transaction.infrastructure.entity.User;
import com.bdg.bank_transaction.infrastructure.repository.UserRepository;
import com.bdg.bank_transaction.utils.enumaration.Role;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User register(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User changeRole(int id,int role) {
        return this.userRepository.findById(id).map(user -> {
            user.setRole(Role.getById(role));
            return userRepository.save(user);
        }).get();
    }

    @Override
    public User getById(int id) {
        return userRepository.findById(id).get();
    }


}
