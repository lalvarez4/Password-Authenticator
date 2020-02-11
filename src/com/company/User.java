package com.company;

/**
 * Stores relevant attributes for a user such as the associated password. Includes helper functions.
 * @author
 */
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

    /**
     * Returns userID
     * @return
     */
    String getUserID(){
        return userID;
    }

    /**
     * Returns username
     * @return
     */
    String getUsername(){
        return username;
    }

    /**
     * Returns salt
     * @return
     */
    String salt(){
        return this.salt;
    }

    /**
     * Returns passwordHash
     * @return
     */
    int passwordHash(){
        return passwordHash;
    }
}
