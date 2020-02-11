package com.company;

public class User {
    String userID;
    String username;
    String password;
    String salt;
    int passwordHash;


    public User(String username, String password, String salt, int passwordHash){
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.passwordHash = passwordHash;
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

    int passwordHash(){
        return passwordHash;
    }
}
