package com.example.springclientjdbc.service;


public enum AccountStaments {
    //Query for Jdbc Client
    FINDALL("SELECT * FROM account"),
    FINDID("SELECT * FROM account WHERE id = :id"),
    CREATE("INSERT INTO account(id,name,email) VALUES(?,?,?)"),
    UPDATE("UPDATE account SET name = ? , email = ? WHERE id = ?"),
    DELETE("DELETE FROM account WHERE id = :id"), ID("id"),

    //Query for Jdbc Template
    DELETEtem("DELETE FROM account WHERE id = ?");

    private final String stements;
    AccountStaments(String stements) {
        this.stements = stements;
    }
    public String getStements(){
        return stements;
    }
}
