/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registration;

/**
 *
 * @author RC_Student_lab
 */

import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;


public class MessageHandler {
    
    public static void storeMessageToJSON(String recipient, String message) {
        JSONObject obj = new JSONObject();
        obj.put("Recipient", recipient);
        obj.put("Message", message);

        try (FileWriter file = new FileWriter("messages.json", true)) {
            file.write(obj.toJSONString());
            file.write("\n");
        } catch (IOException e) {
            System.out.println("Error writing to JSON: " + e.getMessage());
        }
    }

    
}
