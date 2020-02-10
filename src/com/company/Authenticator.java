package com.company;

import java.util.Scanner;
import java.util.Random;

public class Authenticator{

    public static void main(String []args) {

        System.out.println("Password Authenticator");
        System.out.println("1. Add User | 2. Remove User | 3. Sign In");

        Scanner kb = new Scanner(System.in);
        int menu = kb.nextInt();

        switch(menu){
            case 1:
                addUser();

                break;
            case 2:
                System.out.println();
            default:
                System.out.println("Try Again");
        }

    }

    static int addUser(){
        String username;
        String password;
        Scanner kb = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter user name: ");
        username = kb.nextLine();
        System.out.print("Enter password: ");
        password = kb.nextLine();

        StringBuilder strPassword = new StringBuilder(password);

        char[] saltTable = {'!', '@', '#', '$', '%', '^', '&', '*'};

        StringBuilder salt = new StringBuilder();

        for(int i = 0; i < 4; i++){
            salt.append(saltTable[random.nextInt(7)]);
        }

        strPassword.append(salt);

        System.out.println(strPassword.toString());

        User newUser = new User(username, password);

        password.hashCode();

        return 0;
    }

    void removeUser(){

    }


}
