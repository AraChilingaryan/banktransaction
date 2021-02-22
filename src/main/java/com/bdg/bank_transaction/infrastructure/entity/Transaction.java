package com.bdg.bank_transaction.infrastructure.entity;

import com.bdg.bank_transaction.utils.enumaration.Status;
import com.bdg.bank_transaction.utils.enumaration.TransactionTypes;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.ORDINAL)
    @Column
    private TransactionTypes transactionTypes;

    @Enumerated(EnumType.ORDINAL)
    @Column
    private Status status;

    @Column
    private double sum;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Account accounts;

    public Transaction(TransactionTypes transactionTypes, Status status, double sum) {
        this.transactionTypes = transactionTypes;
        this.status = status;
        this.sum = sum;
    }

    public Transaction() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TransactionTypes getTransactionTypes() {
        return transactionTypes;
    }

    public void setTransactionTypes(TransactionTypes transactionTypes) {
        this.transactionTypes = transactionTypes;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Account getAccounts() {
        return accounts;
    }

    public void setAccounts(Account accounts) {
        this.accounts = accounts;
    }
}
