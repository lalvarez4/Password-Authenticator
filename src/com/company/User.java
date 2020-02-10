package com.company;

public class User {
    String userID;
    String username;
    String password;
    String salt;
    String passwordHash;


    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    String getUserID(){
        return userID;
    }

    String getUsername(){
        return username;
    }

    String salt(){
        return this.salt;
    }

    String passwordHash(){
        return passwordHash;
    }
}
