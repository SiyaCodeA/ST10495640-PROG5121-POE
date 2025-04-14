/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registration;

/**
 *
 * @author RC_Student_lab
 */
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;
import java.util.Random;



// corrections  
import java.util.Random;

public class Message {
    private String messageID;
    private String recipient;
    private String message;
    private String messageHash;
    private int totalMessages = 0;

    // Constructor with parameters
    public Message(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash(message);
    }
    
    // Default constructor (required for Gson)
public Message() {
}


    // Getters
    public String getMessageID() { return messageID; }
    public String getMessageHash() { return messageHash; }
    public String getRecipient() { return recipient; }
    public String getMessage() { return message; }

    // Setters
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setMessage(String message) {
        this.message = message;
        this.messageHash = createMessageHash(message);
    }

    // Generate message ID
    public static String generateMessageID() {
        Random rand = new Random();
        return String.format("%010d", rand.nextInt(1_000_000_000));
    }

    // Validate message length
    public String validateMessageLength(String message) {
        if (message.length() <= 250) {
            return "Message ready to send.";
        } else {
            int extra = message.length() - 250;
            return "Message exceeds 250 characters by " + extra + ", please reduce size.";
        }
    }

    // Validate recipient number format
    public boolean validateRecipient(String recipient) {
        return recipient.matches("^\\+\\d{10,13}$");
    }

    // Create message hash 
    public String createMessageHash(String message) {
        if (message.length() < 2) {
            return "Invalid message for hash";
        }
        return "00:0:" + message.substring(0, 2).toUpperCase() + ":" + 
               message.substring(0, 2).toUpperCase() + ":" + 
               message.substring(message.length() - 2).toUpperCase();
    }

    // Handle send/store/disregard choices
    public String sentMessage(String choice) {
        switch (choice.toLowerCase()) {
            case "send":
                totalMessages++;
                return "Message successfully sent.";
            case "store":
                // Imagine store logic here
                return "Message successfully stored.";
            case "disregard":
                return "Press 0 to delete message.";
            default:
                return "Invalid choice";
        }
    }

    // Getter for total messages sent 
    public int getTotalMessages() {
        return totalMessages;
    }
}


