package com.example.springclientjdbc;

import com.example.springclientjdbc.datasource.Account;
import com.example.springclientjdbc.service.AccountService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringClientJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringClientJdbcApplication.class, args);
    }


}
