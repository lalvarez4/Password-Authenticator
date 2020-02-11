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
     * @return 0
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
        password = passwordCheck();

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
     * @return 0
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
     * @return 0
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

    /**
     * Walks user through entering a valid password.
     * @return password
     */
    static String passwordCheck(){
        boolean isValid = false;
        String password;
        Scanner kb = new Scanner(System.in);
        do {
            boolean has8thru16 = false; //size check
            boolean hasUpper = false;
            boolean hasLower = false;
            boolean hasSpecial = false; //has any character from String specialCharacters check
            boolean hasStringPassword = false;
            boolean hasSpace = true;

            String specialCharacters = "!#$%&'()*+,-./:;<=>?@[]^_`{|}~"; //stores special characters
            String raspberryPiPassword = "Password"; //Password shouldn't contain 'password'

            password = kb.nextLine();

            //If the password contains between 8 and 16 characters, it passes the size check
            if (password.length() >= 8 && password.length() <= 16) {
                has8thru16 = true;
            }

            /*If the password is not equal to an all lowercase version of itself, it means the original version contains
            an upper case character*/
            if (password != password.toLowerCase()) {
                hasUpper = true;
            }

            //Same as above if statement, except for lower case check
            if (password != password.toUpperCase()) {
                hasLower = true;
            }

            /*Converts String specialCharacters into String[] specialAt. Then checks through the array to see if
            String password contains any element from the array. Solves the special character check*/
            for (int i = 0; i < specialCharacters.length(); i++) {
                String[] specialAt = specialCharacters.split("");
                if (password.contains(specialAt[i])) {
                    hasSpecial = true;
                }
            }

            //Checks if the password contains a multi-case variation of the string 'password'
            if (password.contains(raspberryPiPassword.toLowerCase()) || password.contains(raspberryPiPassword.toUpperCase())
                    || password.contains(raspberryPiPassword)) {
                hasStringPassword = true;
            }

            if (password.indexOf(" ") == -1) {
                hasSpace = false;
            }

            //Final check, makes sure each requirement has been met
            if (has8thru16 && hasUpper && hasLower && hasSpecial && !hasStringPassword && !hasSpace) {
                isValid = true;
            } else {
                //If password is invalid, returns this message and continues looping
                System.out.println("Password not valid. Please try again.");
                System.out.println("Password must contain 8-16 characters, contain <at least> 1 uppercase value,\n" +
                        "1 lower case value, 1 special character, cannot contain 'password', and contains 0\n" +
                        "spaces." );
            }

        }while(!isValid);

        return password;
    }
}
