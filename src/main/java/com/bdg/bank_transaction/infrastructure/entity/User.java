package com.bdg.bank_transaction.infrastructure.entity;

import com.bdg.bank_transaction.utils.enumaration.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String firstName;


    @Enumerated(EnumType.ORDINAL)
    @Column
    private Role role;

    //@JsonBackReference
    @OneToMany(mappedBy = "users",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Account> accountSet = new HashSet<>();

    public void addPassenger(Account account) {
        accountSet.add(account);
        account.setUsers(this);
    }

    public void removePassenger(Account account) {
        accountSet.remove(account);
        account.setUsers(null);
    }

    public User(String firstName, Role role) {
        this.firstName = firstName;
        this.role = role;
    }


    public User() {
    }

    public Set<Account> getAccountSet() {
        return accountSet;
    }

    public void setPassengerSet(Set<Account> accountSet) {
        this.accountSet = accountSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
