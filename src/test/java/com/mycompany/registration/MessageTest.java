/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.registration;

//import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RC_Student_lab
 */
public class MessageTest {
    
    
    private Message message;

    @Before
    public void setUp() {
        message = new Message("+27831234567", "HITONIGHT");
    }

    @Test
    public void testValidateMessageLength_Success() {
        String shortMsg = "This is a valid message.";
        assertEquals("Message ready to send.", message.validateMessageLength(shortMsg));
    }

    @Test
    public void testValidateMessageLength_Failure() {
        StringBuilder longMsg = new StringBuilder();
        for (int i = 0; i < 260; i++) longMsg.append("a");
        String expected = "Message exceeds 250 characters by 10, please reduce size.";
        assertEquals(expected, message.validateMessageLength(longMsg.toString()));
    }

    @Test
    public void testValidateRecipient_Success() {
        assertTrue(message.validateRecipient("+27831234567"));
    }

    @Test
    public void testValidateRecipient_Failure() {
        assertFalse(message.validateRecipient("0831234567"));
        assertFalse(message.validateRecipient("+271234"));   // too short
        assertFalse(message.validateRecipient("+278312345678901234")); // too long
        assertFalse(message.validateRecipient("27831234567"));  // missing +
    }

    @Test
    public void testCreateMessageHash_Correctness() {
        String expectedHash = "00:0:HI:HI:HT";
        assertEquals(expectedHash, message.createMessageHash("HITONIGHT"));
    }

    @Test
    public void testGenerateMessageID_Length() {
        String id = Message.generateMessageID();
        assertEquals(10, id.length());
        assertTrue(id.matches("\\d{10}")); // digits only
    }

    @Test
    public void testSentMessage_Send() {
        String result = message.sentMessage("send");
        assertEquals("Message successfully sent.", result);
    }

    @Test
    public void testSentMessage_Store() {
        String result = message.sentMessage("store");
        assertEquals("Message successfully stored.", result);
    }

    @Test
    public void testSentMessage_Disregard() {
        String result = message.sentMessage("disregard");
        assertEquals("Press 0 to delete message.", result);
    }

    @Test
    public void testSentMessage_InvalidChoice() {
        String result = message.sentMessage("unknown");
        assertEquals("Invalid choice", result);
    }
}

