package com.example.springclientjdbc.service;

import com.example.springclientjdbc.datasource.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemplateAccount implements AccountService{
    private static final Logger log = LoggerFactory.getLogger(TemplateAccount.class);
    private final JdbcTemplate jdbcTemplate;

    public TemplateAccount(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Account> rowMapper = (rs, row) ->new Account(
            rs.getString("id"),
            rs.getString("name"),
            rs.getString("email")
    );
    @Override
    public List<Account> findAll() {
        return jdbcTemplate.query(AccountStaments.FINDALL.getStements(),rowMapper);
    }

    @Override
    public void create(Account account) {
        int inert = jdbcTemplate.update(AccountStaments.CREATE.getStements(),account.id(),account.name(),account.email());
        if (inert == 1) {
            log.info("New create: " + account.name());
        }
    }

    @Override
    public Optional<Account> findId(String id) {
        String sql = "SELECT id,name,email FROM account WHERE id = ?";
        Account account = null;
        try {
            account = jdbcTemplate.queryForObject(sql, rowMapper,id);
        } catch (DataAccessException ex){
            log.info("Find not found" + id,ex);
        }
        return Optional.ofNullable(account);
    }

    @Override
    public void update(String id, Account account) {
       String sql = AccountStaments.UPDATE.getStements();
       int update = jdbcTemplate.update(sql,account.name(),account.email(),id);
       if (update == 1){
           log.info("Update fail " + account.name());
       }
    }

    @Override
    public void delete(String id) {
        String sql = AccountStaments.DELETEtem.getStements();
        int delete = jdbcTemplate.update(sql,id);
        if (delete == 1) {
            log.info("Delete fail" +  id);
        }
    }
}
