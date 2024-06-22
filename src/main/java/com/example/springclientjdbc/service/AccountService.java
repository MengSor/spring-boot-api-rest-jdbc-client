package com.example.springclientjdbc.service;

import com.example.springclientjdbc.datasource.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    List<Account> findAll();
    void create(Account account);
    Optional<Account>  findId(String id);
    void update(String id, Account account);
    void delete(String id);
}
