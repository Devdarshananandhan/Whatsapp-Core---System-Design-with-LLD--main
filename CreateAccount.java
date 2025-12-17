package com.chatapp;
public class CreateAccount {
    String userid;
    String name;
    int password;
    int phoneno;
    User user;

    CreateAccount(String userid, String name, int password, int phoneno){
        this.userid = userid;
        this.name = name;
        this.password = password;
        this.phoneno = phoneno;
    }

    // create user and keep reference on this object (no return)
    void createUser(){
        this.user = new User(this.userid, this.name, this.password, this.phoneno);
    }


}
