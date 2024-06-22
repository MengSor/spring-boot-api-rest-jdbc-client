package com.example.springclientjdbc.service;


import com.example.springclientjdbc.datasource.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service

public class AccountClientService implements AccountService{
    private static final Logger log = LoggerFactory.getLogger(AccountClientService.class);
    private final JdbcClient jdbcClient;
    public AccountClientService(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }
    @Override
    public List<Account> findAll() {
        return jdbcClient.sql(AccountStaments.FINDALL.getStements())
                .query(Account.class)
                .list();
    }
    @Override
    public Optional<Account> findId(String id) {
        return jdbcClient.sql(AccountStaments.FINDID.getStements())
                .param("id",id)
                .query(Account.class)
                .optional();
    }

    @Override
    public void update(String id, Account account) {
        var update = jdbcClient.sql(AccountStaments.UPDATE.getStements())
                .params(List.of(account.name(),account.email(),id))
                .update();
        if (update == 1) {
            log.info("Update" + account.name());
        }
    }

    @Override
    public void delete(String id) {
        var delete = jdbcClient.sql(AccountStaments.DELETE.getStements())
                .param("id",id)
                .update();

        Assert.state(delete == 1, "Failed Delete" + id);
    }

    @Override
    public void create(Account account) {
        int insert = jdbcClient.sql(AccountStaments.CREATE.getStements())
                .params(List.of(account.id(),account.name(),account.email()))
                .update();

        Assert.state(insert == 1,"Failed create " + account.name());
    }

}
