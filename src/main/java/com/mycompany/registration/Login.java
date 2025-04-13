/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registration;

/**
 *
 * @author RC_Student_lab
 */
import java.util.regex.*;

public class Login {
    //attributes
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String cellNumber;
    
    //constructor
    public Login(String firstName, String lastName, String userName, String password, String cellNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.cellNumber = cellNumber;
    }
    
    //getter and setter methods 
    //getter methods for firstname 
    public String getFirstname(String firstName){
       return firstName;
    }
    //setter method
    public void setFirstname(String firstName){
        this.firstName = firstName;
    }
    
    
    public String getLastname(String lastName){
        return lastName;
    }
    public void setLastname(String lastName){
        this.lastName = lastName;
    }
    
    
    public String getUsername(String userName){
        return userName;
    }
    
    public void setUsername(String userName){
        this.userName = userName;
    }
    
    
    public String getPassword(String password){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getCellnumber(String cellNumber){
        return cellNumber;
    }
    
    public void setCellnumber(String cellNumber){
        this.cellNumber = cellNumber;
    }
        
    
   
       
        //username  method
        public static boolean checkUserName(String userName){
            if ( userName.contains("_")&&userName.length()<=5){
                System.out.println(userName);
            return true;
            }
            else{
                return false;
            }
        }
        
        
        
        //password method
        public static boolean checkPasswordComplexity(String password){
            boolean hasUppercase = false;
            boolean hasDigit = false;
            boolean hasSpecialCharacter = false;
            
            if ( password.length() >=8 &&
                    password.matches(".*[A-Z].*") &&
                    password.matches(".*[a-z].*") &&
                    password.matches(".*[0-9].*") &&
                    password.matches(".*[!@#$%^&*()].*")){
                hasUppercase = true;
                hasDigit = true;
                hasSpecialCharacter = true;
                }
       
                return  hasUppercase && hasDigit && hasSpecialCharacter;
                
        }
        
        //cell phone method
        //ai
        public static boolean checkCellPhoneNumber(String cellNumber){
            String regex = "^(?:\\+27|27|0)(6|7|8)[0-9]{8}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(cellNumber);
            return matcher.matches();
        }
        
        
     
        
        //register method to return necessary registration messaging
        public static String registerUser(String userName, String password, String cellNumber){
            if (checkUserName(userName)){
                return "Username succesfully captured.";
            }
            else if (checkPasswordComplexity(password)){
                return "Password successfully captured.";
            }
            else if (checkCellPhoneNumber(cellNumber)){
                return " Cell phone number successfully added.";
            }
            else if (!checkUserName(userName)) {
            return "Username is not correctly formatted,please ensure that your username contains an underscore and is no more than five characters in length.";
            }
            else if (!checkPasswordComplexity(password)) {
                return "Password is not correctly formatted,please ensure that the password contains at least eight characters, a capital letter, a number ,and a special character";
            }
            else {
                return " Cell phone number incorrectly formatted or does not contain international code.";
            }
        }
           
 
        //login method
        public static boolean loginUser(String ploginUser, String ploginPass, String userName, String password){
            if (ploginUser.equals(userName) && ploginPass.equals(password)){
            return true;
            }
            else {
                return false;
            }
        }
        
        //returning login status method
        public static String returnLoginStatus(String ploginUser,String ploginPass,  String userName, String password, String firstName, String lastName){
            if(loginUser( ploginUser,ploginPass , userName, password)){
               return " Welcome "+ firstName +","+ lastName +" it is great to see you.";
            }
            else {
                return "Username or password incorrect,please try again.";
                    }
           
}
}



                   
          
            
        
    
    
    

