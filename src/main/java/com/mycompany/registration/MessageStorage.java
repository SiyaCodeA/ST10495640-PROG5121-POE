/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registration;

/**
 *
 * @author RC_Student_lab
 */

// File: MessageStorage.java
 

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MessageStorage {
    

    public static void saveMessagesToFile(List<Message> messages, String filename) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(messages);

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(jsonString);
            System.out.println("Messages saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Message> readMessagesFromFile(String filename) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filename)) {
            Type listType = new TypeToken<List<Message>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void appendMessageToFile(Message newMessage, String filename) {
        List<Message> messages = readMessagesFromFile(filename);
        if (messages == null) messages = new ArrayList<>();
        messages.add(newMessage);
        saveMessagesToFile(messages, filename);
    }
}

    
   

    