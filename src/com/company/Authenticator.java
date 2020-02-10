package com.company;

import java.util.Scanner;

public class Authenticator{

    public static void main(String []args) {

        System.out.println("Password Authenticator");
        System.out.println("1. Add User | 2. Remove User | 3. Sign In");

        Scanner kb = new Scanner(System.in);
        int menu = kb.nextInt();

        switch(menu){
            case 1:
                //addUser();

                break;
            case 2:
                System.out.println();
            default:
                System.out.println("Try Again");
        }

    }

    void addUser(){
        String username;
        String password;
        Scanner kb = new Scanner(System.in);

        System.out.print("Enter user name: ");
        username = kb.nextLine();
        System.out.print("Enter password: ");
        password = kb.nextLine();

        User newUser = new User(username, password);

        password.hashCode();
    }

    void removeUser(){

    }


}
