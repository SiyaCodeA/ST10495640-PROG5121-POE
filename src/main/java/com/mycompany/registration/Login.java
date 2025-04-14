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
//(OpenAI,2025)

public class Login {
    //attributes
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String cellNumber;
    
    //default constructor
    public Login(){
        this.firstName = "";
        this.lastName = "";
        this.userName = "";
        this.password = "";
        this.cellNumber = "";
    }
    
    //constructor
    public Login(String firstName, String lastName, String userName, String password, String cellNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.cellNumber = cellNumber;
    } //(IIE,2025)
    
    //getter and setter methods 
    public String getFirstname(String firstName){
       return firstName;
    }
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
    } //IIE(2025)
        
    
   
       
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
        public static boolean checkCellPhoneNumber(String cellNumber){
            String regex = "^(?:\\+27|27|0)(6|7|8)[0-9]{8}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(cellNumber);
            return matcher.matches();
        } //(OpenAI,2025)
        
        
     
        
        //register method to return necessary registration messaging
        public static String registerUser(String userName, String password, String cellNumber){
            if (checkUserName(userName)){
                return "username successfully captured.";
            }
            else if (checkPasswordComplexity(password)){
                return "  Password successfully captured.";
                
            }
            else if (checkCellPhoneNumber(cellNumber)){
                return "cellphone number succeffully captured.";
            }
            else if (!checkUserName(userName)){
                return "username not correctly formatted.";
            }
            else if (!checkPasswordComplexity(password)){
                return "password not correctly formatted.";
            }
            else {
                return "cellphone number incorrectly formatted.";
            }
            }
            
 
        //login method
        public static boolean loginUser(String loginName, String loginPass, String userName, String password){
            if (loginName.equals(userName) && loginPass.equals(password)){
            return true;
            }
            else {
                return false;
            }
        }
        
        //returning login status method
        public static String returnLoginStatus(String loginName,String loginPass,  String userName, String password, String firstName, String lastName){
            if(loginUser( loginName,loginPass , userName, password)){
               return " Welcome "+ firstName +","+ lastName +" it is great to see you.";
            }
            else {
                return "Username or password incorrect,please try again.";
                    }
           //(zuhayr,2023)
}
}



                   
          
            
        
    
    
    

