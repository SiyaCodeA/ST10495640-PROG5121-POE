/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registration;

/**
 *
 * @author RC_Student_lab
 */

import javax.swing.JOptionPane;
import java.util.*;
import java.io.FileWriter;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;

import java.io.*;



public class MessageArrays {
    
    //declaring arrays
    public static String[] sentMessages = new String[10];
    public static String[] disregardedMessages = new String[10];
    public static String[] storedMessages = new String[10];
    public static String[] messageHashes = new String[10];
    public static String[] messageIDs = new String[10];
    public static String[] sentRecipients = new String[10];
    
    //index counters for the arrays
    public static int sentIndex = 0;
    public static int disregardIndex = 0;
    public static int storedIndex = 0;
    public static int hashIndex = 0;
    public static int idIndex = 0;
   
    //methods
//method to add messages
    public static void addMessages(String recipient, String message, int category){
        String hash = Integer.toString(message.hashCode());//generate simple hash
        String id = "MSG" +(idIndex +1); //create message id like MSG1,MSG2 ect.
        
        //check the category to decide where to store mesage 
        switch (category) {
        case 1: // Sent
            if(sentIndex < sentMessages.length){
                sentMessages[sentIndex] = message;
                sentRecipients[sentIndex] = recipient;
                sentIndex++;
            } 
            else {
            System.out.println("Sent messages array is full");
            }
            break;
        case 2: // Disregard
            if(disregardIndex <disregardedMessages.length){
                disregardedMessages[disregardIndex] = message;
                disregardIndex++;
            }
            else{
                System.out.println("Disregarded message array is full");
            }
            break;
        case 3: // Stored
            if(storedIndex < storedMessages.length){
                storedMessages[storedIndex] = message;
                storedIndex++;
            }
            else{
                System.out.println("Stored messages array is full.");
            }
            break;
        default:
            System.out.println("Invalid category.");
            return;
    }
        
        
        //storing message hash and id
        messageHashes[hashIndex++] = hash;
        messageIDs[idIndex++] = id;
    }
    
   
       
    //to display longest sent message
    public static String getLongestSentMessage() {
        String longest = "";
        for (int i = 0; i< sentIndex; i++){
            if(sentMessages[i].length()>longest.length()){
                longest = sentMessages[i];
            }
        }
        return longest;
    }
    
    
    //searching for message using message ID
    public static String searchByMessageID(String id){
        for(int i = 0; i <idIndex;i++){
            if(messageIDs[i].equals(id)){
                return "To:"+ sentRecipients[i]+ "|Message:" + sentMessages[i];
                
            }
        }
        return "Message ID not found.";
    }
    
    
    //delete message using its hash
    public static void deleteMessageByHash(String hash){
        for(int i = 0; i < hashIndex; i++){
            if (messageHashes[i] != null && messageHashes[i].equals(hash)){
                sentMessages[i] = null;
                sentRecipients[i] = null;
                messageIDs[i] = null;
                messageHashes[i] = null;
                System.out.println("Message deleted.");
                return;   
            }
        }
        System.out.println("Hash not found.");
        
    }
    
    //find all messages sent to specific recipient
    public static void searchByRecipient(String number){
        boolean found = false;
        for(int i = 0; i < sentIndex; i++){
            if(sentRecipients[i] != null && sentRecipients[i].equals(number)){
                System.out.println("Message to " + number + ":"+ sentMessages[i]);
                found = true;
            } 
        }
        if(!found){
            System.out.println("No messages found for recipient.");
        }
    }
    
    //show sender recipient
    public static void displaySenderRecipient() {
    for (int i = 0; i < sentIndex; i++) {
        if (sentMessages[i] != null) { // Ensure the message is not null
            System.out.println("Sender: YOU, Recipient: " + sentRecipients[i]);
        }
    }
}       
    
    //to display full report
    public static void displayFullReport(){
        for (int i = 0; i< sentIndex; i++){
            if(sentMessages[i] != null){
            System.out.println("Message Hash:"+ messageHashes[i]);
            System.out.println("Recipient:"+ sentRecipients[i]);
            System.out.println("Message:"+ sentMessages[i]);
            System.out.println("Message id:" + messageIDs[i]);
            System.out.println("-------------------------------");
        }
    }
}
    //read message from file 
    public static void readStoredMessagesFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("storedMessages.txt"));
            String line;
            while ((line = reader.readLine()) != null && storedIndex < storedMessages.length) {
                storedMessages[storedIndex++] = line;
                System.out.println("Stored Message Loaded: " + line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading stored messages from file: " + e.getMessage());
        }
    }
}



