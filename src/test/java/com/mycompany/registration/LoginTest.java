/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.registration;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class LoginTest {

    public void LoginTest() {
       
    }

    @Test
    public void testCheckUserNameCorrectFormat() {
        assertTrue(Login.checkUserName("kyl_1"));
    }
    
    @Test
    public void testCheckUserNameIncorrectFormat() {
        assertFalse(Login.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testCheckPasswordComplexityCorrectFormat() {
        assertTrue(Login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }
    
    @Test
    public void testCheckPasswordComplexityIncorrectFormat() {
        assertFalse(Login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCheckCellPhoneNumberCorrectFormat() {
        assertTrue(Login.checkCellPhoneNumber("+27838968976"));
    }
    
    @Test
    public void testCheckCellphoneNumberIncorrectFormat() {
        assertFalse(Login.checkCellPhoneNumber("08966553"));
    }


    @Test
    public void testLoginUserSuccessful() {
        assertTrue(Login.loginUser("kyl_1","Ch&&sec@ke99!","kyl_1","Ch&&sec@ke99!"));
    }
    
    @Test
    public void testLoginUserFailed() {
        assertFalse(Login.loginUser("kyl_1", "incorrectPassword","kyl_1","Ch&&sec@ke99!"));
    }

    @Test
    public void testCheckUserNameCorrectFormatReturnsTrue() {
        assertTrue(Login.checkUserName("kyl_1"));
    }
    
}
