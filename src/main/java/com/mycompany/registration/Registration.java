/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registration;

/**
 *
 * @author RC_Student_lab
 */
import java.util.Scanner;



public class Registration {

    public static void main(String[] args) {
       
        Login loginObj = new Login();
        
        
        Scanner input = new Scanner(System.in);

        String firstName;
        String lastName;
        String userName;
        String password;
        String cellNumber;
        
        
        System.out.println("Registration");
        
        System.out.print("Enter your first name:");
        firstName = input.nextLine();
        loginObj.setFirstname(firstName);
        
        System.out.print("Enter your last name:");
        lastName = input.nextLine();
        loginObj.setLastname(lastName);
        
        System.out.print("\n" + "Create your user name"
        + "\n*Note that your username:"
        +"\n- must not exceed 5 characters in length and"
        +"\n- must contain an underscore(_)."
        +"\nEnter a username:");
        userName = input.nextLine();
        loginObj.setUsername(userName);
        loginObj.checkUserName(userName);
        
        System.out.print("\n" + "Create your password"
        + "\n*Note that your password must:"
        +"\n-contain atleast 8 characters,"
        +"\n-contain a capital letter,"
        +"\n-contain a digit and"
        +"\n-contain a special character."
        +"\nEnter password:");
        password = input.nextLine();
        loginObj.setPassword(password);
        loginObj.checkPasswordComplexity(password);
        
        System.out.print("\n" + "Enter your cellphone number"
        +"\n*Note that your number must:"
        +"\n-contain international country code(+27)"
        +"\nEnter cellphone number:");
        cellNumber = input.nextLine();
        loginObj.setCellnumber(cellNumber);
        loginObj.checkCellPhoneNumber(cellNumber);
        
        System.out.println(loginObj.registerUser(userName,password,cellNumber)); //calling register user (to validate) and printing it out 
     
        System.out.println("Login");
        
        System.out.print("enter your username:");
        userName = input.nextLine();
        String loginName = userName;
        
        loginObj.setUsername(userName);
        
        
        System.out.print("enter your password:");
        password = input.nextLine();
        String loginPass = password;
        loginObj.setPassword(password);
        
        System.out.print(loginObj.returnLoginStatus(loginName,loginPass,userName,password,firstName,lastName));
        
      
    } //(IIE,2025)
    //(Farrell,2019)
    //(Raven,2023)
}   
   