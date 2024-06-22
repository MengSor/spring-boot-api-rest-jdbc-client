package com.example.springclientjdbc.controller;

import com.example.springclientjdbc.datasource.Account;
import com.example.springclientjdbc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class AccountController {

    private final AccountService accountService;

    public AccountController(@Qualifier("templateAccount") AccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping("")
    public List<Account>  findAll(){
       return accountService.findAll();
    }
   @GetMapping("/{id}")
    public Optional<Account> findId(@PathVariable String id){
        return accountService.findId(id);
    }
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED,reason = "Create successfully")
    public void create(@RequestBody Account account){
        accountService.create(account);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable String id,@RequestBody Account account){
        accountService.update(id, account);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        accountService.delete(id);
    }

}
