package com.example.goodnews;

public class User {

    public String name, email_address, password;

    public User(String name, String email_address, String password){
        this.name = name;
        this.email_address = email_address;
        this.password = password;
    }

    public User(String email_address, String password){
        this.name = name;
        this.email_address = email_address;
        this.password = password;
    }
}
