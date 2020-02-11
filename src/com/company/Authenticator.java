package com.company;

import java.util.Scanner;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Authenticator houses the main function of the Password-Authenticator app. This app takes in a username and valid
 * password and stores them into a class User object. Information (username, salt, hashcode) are stored locally.
 * @author Louis Alvarez
 */
public class Authenticator{
    /**
     * User is allowed a menu entry for: adding user, removing user, and signing in
     * @param args
     */
    public static void main(String []args) throws IOException {
        Scanner kb = new Scanner(System.in);

        while(true){
            System.out.println("Password Authenticator");
            System.out.print("1. Add User | 2. Remove User | 3. Sign In: ");
            int menu = kb.nextInt();

            // Switch case handles menu entry
            switch(menu){
                case 1:
                    addUser();
                    break;
                case 2:
                    removeUser();
                    break;
                case 3:
                    signIn();
                    break;
                default:
                    System.out.println("Check input. Try Again\n");
            }
        }


    }

    /**
     * Takes username and password data, creates a salt then hashes the password-salt combo. Then creates a User
     * object. Finally, stores username, salt, and hash in a csv file.
     * @return
     */
    static int addUser() throws IOException{
        String username;
        String password;
        int passwordHash;
        StringBuilder strPassword;
        StringBuilder salt = new StringBuilder();
        FileWriter users = new FileWriter("users.txt");
        Scanner kb = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Add User");
        System.out.println("--------");
        System.out.print("Enter user name: ");
        username = kb.nextLine();
        System.out.print("Enter password: ");
        password = kb.nextLine();

        strPassword = new StringBuilder(password); // Generates a StringBuilder object from password

        char[] saltTable = {'!', '@', '#', '$', '%', '^', '&', '*'}; // Randomly appended to salt from this list

        // Generates a salt of size 4 to be later appended onto the password
        for(int i = 0; i < 4; i++){
            salt.append(saltTable[random.nextInt(7)]);
        }

        strPassword.append(salt); // Appends the randomly generated salt to the password

        passwordHash = password.hashCode(); // Creates a hashcode of the password+salt

        User newUser = new User(username, password, salt.toString(), passwordHash); // Generates a User object

        users.append("0000" + "," + username + "," + password + "," + salt + "," + passwordHash);
        users.close();

        System.out.println();
        return 0;
    }

    /**
     * Creates ArrayList<User> from users.txt and then searches to find the element with the same username as entered.
     * Removes that object from ArrayList<User> then rewrites users.txt.
     * @return
     */
    static int removeUser(){
        String username;
        Scanner kb = new Scanner(System.in);

        System.out.println("Remove User");
        System.out.println("-----------");
        System.out.print("Enter username: ");
        username = kb.nextLine();



        return 0;
    }

    /**
     * Takes a username and password. Checks to see if a username in ArrayList<User> (composed from users.txt) matches
     * that username, pulls the salt and hash from that. If username matches, appends the supplied salt to entered
     * password, hashes the result and compares to the stored hash. If they match, user is successfully logged in.
     * @return
     */
    static int signIn(){
        String username;
        String password;
        String salt;
        int passwordHash;
        Scanner kb = new Scanner(System.in);

        System.out.println("Sign In");
        System.out.println("-------");
        System.out.print("Enter username: ");
        username = kb.nextLine();
        System.out.print("Enter password: ");
        password = kb.nextLine();

        StringBuilder strPassword = new StringBuilder(password);
        

        return 0;
    }
}
