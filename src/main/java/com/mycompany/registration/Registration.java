/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registration;

/**
 *
 * @author RC_Student_lab
 */
import java.util.Scanner;
import java.util.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
         
        

// part 3

public class Registration {

    public static void main(String[] args) {
        
        List<String> registeredUsers = new ArrayList<>();
        List<String> registeredPasswords = new ArrayList<>();
        List<String> registeredCellNumbers = new ArrayList<>();

        // Registration
        String firstName = JOptionPane.showInputDialog("Enter your first name:");
        String lastName = JOptionPane.showInputDialog("Enter your last name:");

        String userName;
        while (true) {
            userName = JOptionPane.showInputDialog("Create your username (must contain an underscore and be <= 5 characters):");
            if (userName != null && userName.contains("_") && userName.length() <= 5) {
                break;
            }
            JOptionPane.showMessageDialog(null, "Invalid username. Must contain an underscore and be 5 characters or less.");
        }

        String password;
        while (true) {
            password = JOptionPane.showInputDialog("Create your password (min 8 chars, 1 uppercase, 1 digit, 1 special character):");
            if (password != null &&
                password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[0-9].*") &&
                password.matches(".*[!@#$%^&*()].*")) {
                break;
            }
            JOptionPane.showMessageDialog(null, "Invalid password. Must meet all specified criteria.");
        }

        String cellNumber;
        while (true) {
            cellNumber = JOptionPane.showInputDialog("Enter your cellphone number (+27 followed by 9 digits):");
            if (cellNumber != null && cellNumber.matches("^\\+27\\d{9}$")) {
                break;
            }
            JOptionPane.showMessageDialog(null, "Invalid cellphone number. Must start with +27 and be followed by exactly 9 digits.");
        }

        // Storing valid data
        registeredUsers.add(userName);
        registeredPasswords.add(password);
        registeredCellNumbers.add(cellNumber);
        JOptionPane.showMessageDialog(null, "Registration successful!");

        // Login loop process for username and password
        String loginUserName = null;
        while (true) {
            loginUserName = JOptionPane.showInputDialog("Enter your username:");
            if (loginUserName == null) {
                JOptionPane.showMessageDialog(null, "Login cancelled.");
                return;
            }
            if (registeredUsers.contains(loginUserName)) {
                break; // username found
            } else {
                JOptionPane.showMessageDialog(null, "Username not found. Please try again.");
            }
        }

        int userIndex = registeredUsers.indexOf(loginUserName);

        while (true) {
            String loginPassword = JOptionPane.showInputDialog("Enter your password:");
            if (loginPassword == null) {
                JOptionPane.showMessageDialog(null, "Login cancelled.");
                return;
            }
            if (registeredPasswords.get(userIndex).equals(loginPassword)) {
                JOptionPane.showMessageDialog(null, "Welcome, " + firstName + " " + lastName + "!");
                showMessagingMenu();
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect password. Please try again.");
            }
        }
    }

    //messaging menu
    private static void showMessagingMenu() {
        while (true) {
            String menu = "Menu:\n"
                    + "1) Send messages\n"
                    + "2) Show recently sent messages\n"
                    + "3) Show full report of sent messages\n"
                    + "4) Show longest sent message\n"
                    + "5) Search for message by ID\n"
                    + "6) Search message by recipient\n"
                    + "7) Delete message by hash\n"
                    + "8) Read stored messages from file\n"
                    + "9) Exit\n"
                    + "Enter your choice:";

            String choiceStr = JOptionPane.showInputDialog(menu);
            if (choiceStr == null) break;

            int choice;
            try {
                choice = Integer.parseInt(choiceStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    // Loop to validate recipient number before sending
                    String recipient;
                    while (true) {
                        recipient = JOptionPane.showInputDialog("Enter recipient's number (+27 followed by 9 digits):");
                        if (recipient == null) break;
                        if (recipient.matches("^\\+27\\d{9}$")) {
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid recipient number. Must start with +27 and be followed by exactly 9 digits.");
                        }
                    }
                    if (recipient == null) break; // Cancelled input

                    String message = JOptionPane.showInputDialog("Enter your message:");
                    if (message == null) break;

                    if (message.length() > 250) {
                        JOptionPane.showMessageDialog(null, "Message exceeds 250 characters. It will be disregarded.");
                        MessageArrays.addMessages(recipient, message, 2);
                    } else {
                        MessageArrays.addMessages(recipient, message, 1);
                        JOptionPane.showMessageDialog(null, "Message sent.");
                    }
                    break;

                case 2:
                    StringBuilder recent = new StringBuilder("Recently Sent Messages:\n");
                    for (int i = 0; i < MessageArrays.sentIndex; i++) {
                        if (MessageArrays.sentMessages[i] != null && MessageArrays.sentRecipients[i] != null) {
                            recent.append("To: ").append(MessageArrays.sentRecipients[i])
                                  .append("\nMessage: ").append(MessageArrays.sentMessages[i])
                                  .append("\n\n");
                        }
                    }
                    JOptionPane.showMessageDialog(null, recent.length() > 0 ? recent.toString() : "No sent messages.");
                    break;

                case 3:
                    StringBuilder fullReport = new StringBuilder();
                    for (int i = 0; i < MessageArrays.sentIndex; i++) {
                        if (MessageArrays.sentMessages[i] != null) {
                            fullReport.append("Message Hash: ").append(MessageArrays.messageHashes[i]).append("\n")
                                      .append("Recipient: ").append(MessageArrays.sentRecipients[i]).append("\n")
                                      .append("Message: ").append(MessageArrays.sentMessages[i]).append("\n")
                                      .append("Message ID: ").append(MessageArrays.messageIDs[i]).append("\n")
                                      .append("-------------------------------\n");
                        }
                    }
                    JOptionPane.showMessageDialog(null, fullReport.length() > 0 ? fullReport.toString() : "No messages to show.");
                    break;

                case 4:
                    String longest = MessageArrays.getLongestSentMessage();
                    JOptionPane.showMessageDialog(null, longest.isEmpty() ? "No sent messages." : "Longest Sent Message:\n" + longest);
                    break;

                case 5:
                    String id = JOptionPane.showInputDialog("Enter message ID to search:");
                    if (id == null) break;
                    String foundMsg = MessageArrays.searchByMessageID(id);
                    JOptionPane.showMessageDialog(null, foundMsg);
                    break;

                case 6:
                    String recipientSearch = JOptionPane.showInputDialog("Enter recipient number to search messages:");
                    if (recipientSearch == null) break;
                    StringBuilder foundMessages = new StringBuilder();
                    boolean found = false;
                    for (int i = 0; i < MessageArrays.sentIndex; i++) {
                        if (recipientSearch.equals(MessageArrays.sentRecipients[i]) && MessageArrays.sentMessages[i] != null) {
                            foundMessages.append(MessageArrays.sentMessages[i]).append("\n\n");
                            found = true;
                        }
                    }
                    JOptionPane.showMessageDialog(null, found ? foundMessages.toString() : "No messages found for recipient.");
                    break;

                case 7:
                    String hash = JOptionPane.showInputDialog("Enter message hash to delete:");
                    if (hash == null) break;
                    boolean deleted = false;
                    for (int i = 0; i < MessageArrays.hashIndex; i++) {
                        if (hash.equals(MessageArrays.messageHashes[i])) {
                            MessageArrays.sentMessages[i] = null;
                            MessageArrays.sentRecipients[i] = null;
                            MessageArrays.messageIDs[i] = null;
                            MessageArrays.messageHashes[i] = null;
                            deleted = true;
                            break;
                        }
                    }
                    JOptionPane.showMessageDialog(null, deleted ? "Message successfully deleted." : "Hash not found.");
                    break;

                case 8:
                    MessageArrays.readStoredMessagesFromFile();
                    break;

                case 9:
                    JOptionPane.showMessageDialog(null, "Exiting program...");
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        }
    }
}









 