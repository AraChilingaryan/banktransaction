package com.bdg.bank_transaction.infrastructure.repository;

import com.bdg.bank_transaction.infrastructure.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
