/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registration;

/**
 *
 * @author RC_Student_lab
 */


/*
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;



public class MessageReader {
    
  
    public static ArrayList<String> loadStoredMessages() {
        ArrayList<String> storedMessages = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("messages.json")) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                JSONObject obj = (JSONObject) parser.parse(line);
                storedMessages.add(obj.get("Message").toString());
            }
        } catch (Exception e) {
            System.out.println("Error reading JSON: " + e.getMessage());
        }
        return storedMessages;
    }
   
}
*/

//package com.mycompany.registration;

/*import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.ArrayList;

public class MessageReader {

    public static ArrayList<String> loadStoredMessages() {
        ArrayList<String> storedMessages = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("messages.json")) {
            // Parse the entire JSON file as an array
            JSONArray messagesArray = (JSONArray) parser.parse(reader);

            // Iterate through each message object in the array
            for (Object obj : messagesArray) {
                JSONObject messageObj = (JSONObject) obj;
                String message = (String) messageObj.get("message");
                if (message != null) {
                    storedMessages.add(message);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading JSON: " + e.getMessage());
        }
        return storedMessages;
    }
}
*/
//package com.mycompany.registration;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MessageReader {

    public static List<String> loadStoredMessages() {
        List<String> messages = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("messages.json")) {
            Object obj = parser.parse(reader);
            JSONArray messageList = (JSONArray) obj;

            for (Object msgObj : messageList) {
                JSONObject message = (JSONObject) msgObj;
                String messageText = (String) message.get("message");
                String recipient = (String) message.get("recipient");

                // Assuming you want to display both message and recipient
                messages.add("To: " + recipient + "\nMessage: " + messageText);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error reading messages: " + e.getMessage());
        }

        return messages;
    }
}

