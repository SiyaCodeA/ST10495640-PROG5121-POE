/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.registration;

//import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author RC_Student_lab
 */
public class MessageArraysTest {
    
    public MessageArraysTest() {
    }
    
   
    @Before
    public void setup() {
        // Resetting the arrays and counters
        MessageArrays.sentMessages = new String[10];
        MessageArrays.disregardedMessages = new String[10];
        MessageArrays.storedMessages = new String[10];
        MessageArrays.messageHashes = new String[10];
        MessageArrays.messageIDs = new String[10];
        MessageArrays.sentRecipients = new String[10];

        MessageArrays.sentIndex = 0;
        MessageArrays.disregardIndex = 0;
        MessageArrays.storedIndex = 0;
        MessageArrays.hashIndex = 0;
        MessageArrays.idIndex = 0;

        // Adding test messages
        MessageArrays.addMessages("+27838884567", "Where are you? You are late! I have asked you to be on time.", 1);
        MessageArrays.addMessages("+27838884567", "Ok, I am leaving without you.", 1);
        MessageArrays.addMessages("0838884567", "Did you get the cake?", 1);
        MessageArrays.addMessages("0838884567", "It is dinner time!", 1);
    }

    @Test
    public void testSentMessagesPopulatedCorrectly() {
        assertEquals("Did you get the cake?", MessageArrays.sentMessages[2]);
        assertEquals("It is dinner time!", MessageArrays.sentMessages[3]);
    }

    @Test
    public void testLongestSentMessage() {
        String expected = "Where are you? You are late! I have asked you to be on time.";
        assertEquals(expected, MessageArrays.getLongestSentMessage());
    }

    @Test
    public void testSearchByMessageID() {
        // assuming 4 messages are added, so index 3 = MSG4
        String response = MessageArrays.searchByMessageID("MSG4");
        assertTrue(response.contains("0838884567"));
        assertTrue(response.contains("It is dinner time!"));
    }

    @Test
    public void testSearchByRecipient() {
        MessageArrays.searchByRecipient("+27838884567");
        
    }

    @Test
    public void testDeleteByMessageHash() {
        String messageToDelete = "Where are you? You are late! I have asked you to be on time.";
        String hash = Integer.toString(messageToDelete.hashCode());

        MessageArrays.deleteMessageByHash(hash);
        assertNull(MessageArrays.sentMessages[0]); // assuming it's at index 0
    }

    @Test
    public void testDisplayReport() {
        MessageArrays.displayFullReport();
    }


    /*@Test
    public void testStoreAndReadJSON() {
        MessageHandler.storeMessageToJSON("+27838884567", "Where are you?");
        ArrayList<String> messages = MessageReader.loadStoredMessages();
        assertTrue(messages.contains("Where are you?"));
    }
}
*/
    
@Test
    public void testStoreAndReadJSON() {
        // Store a known message
        String testRecipient = "+27838884567";
        String testMessage = "Where are you?";
        MessageHandler.storeMessageToJSON(testRecipient, testMessage);

        // Load stored messages
        List<String> messages = MessageReader.loadStoredMessages();

        // Expected format based on updated MessageReader
        String expectedFormatted = "To: " + testRecipient + "\nMessage: " + testMessage;

        // Assert that the formatted message exists
        assertTrue("Expected message not found in stored messages.", messages.contains(expectedFormatted));
    }
}
