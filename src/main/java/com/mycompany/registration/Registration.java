/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registration;

/**
 *
 * @author RC_Student_lab
 */import java.util.Scanner;

public class Registration {

    public static void main(String[] args) {
        createAccount();
    }
    
    public static void createAccount(){
        String firstName;
        String lastName;
        String userName;
        String password;
        String cellNumber;
        Scanner input = new Scanner(System.in);
            
        
        System.out.println("Registration");
        
        System.out.print("Enter your first name:");
        firstName = input.nextLine();
        System.out.print("Enter your last name:");
        lastName = input.nextLine();
        System.out.print("Create your user name:");
        userName = input.nextLine();
        System.out.print("Create your password:");
        password = input.nextLine();
        System.out.print("Enter your cellphone number:");
        cellNumber = input.nextLine();
        
        System.out.println(com.mycompany.registration.Login.registerUser(userName,password,cellNumber));
        
        login(userName, password, firstName, lastName);
    }
    
    public static void login(String userName,String password, String firstName, String lastName){
        String loginUser;
        String loginPass;
        Scanner input = new Scanner(System.in);
        
        System.out.println("Login");
        
        System.out.println("Enter the username:");
        loginUser = input.nextLine();
        
        System.out.println("enter the password:");
        loginPass = input.nextLine();
        
        System.out.println(com.mycompany.registration.Login.returnLoginStatus(loginUser, loginPass, userName, password, firstName, lastName));
    }
 
        
    }
    
    
    
