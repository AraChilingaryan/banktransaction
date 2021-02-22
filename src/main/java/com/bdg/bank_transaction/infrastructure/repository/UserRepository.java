package com.bdg.bank_transaction.infrastructure.repository;

import com.bdg.bank_transaction.infrastructure.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
