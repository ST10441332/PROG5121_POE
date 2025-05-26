package com.mycompany.prog.poe;

import java.util.Random;
import java.util.ArrayList;

public class Messages {
    
    private String recipientCell;
    private String messageId;
    private String message;
    private String recipientUsername;
    private static ArrayList<String> sentMessages = new ArrayList<>();
    
    public Messages(String recipientCell) {
        this.recipientCell = recipientCell;
    }

    public Messages() {
    }

    public boolean checkRecipientCell() {
        // Check if number starts with +27 and is exactly 12 characters long
        if (recipientCell != null && recipientCell.startsWith("+27") && recipientCell.length() == 12) {
            // Check that characters after + are all digits
            String digitsOnly = recipientCell.substring(1); // remove '+'
            return digitsOnly.matches("\\d+"); // check if only digits
        }
        return false;
    }

    // Method to check if the message ID is no more than 10 characters
    public boolean checkMessageID(String messageID) {
        return messageID != null && messageID.length() <= 10;
    }

    // Generate a unique 10-digit numeric message ID
    public String generateMessageID() {
        Random rand = new Random();
        StringBuilder id = new StringBuilder();

        // Generate exactly 10 digits
        for (int i = 0; i < 10; i++) {
            id.append(rand.nextInt(10)); // 0-9
        }

        return id.toString();
    }

    public String createMessageHash() {
        if (messageId == null || messageId.length() < 2 || message == null || message.isEmpty()) {
            return "INVALID INPUT";
        }

        String firstTwo = messageId.substring(0, 2);
        String fullId = messageId;

        // Split message into words
        String[] words = message.trim().split("\\s+");

        // Get first and last word
        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        // Combine all parts in uppercase
        String hash = (firstTwo + ":" + fullId + ":" + firstWord + " " + lastWord).toUpperCase();

        return hash;
    }

    // --- NEW METHOD ---
    // Sends a message, stores it in sentMessages, and returns success status
    public boolean sendMessage(String message) {
        if (message == null || message.trim().isEmpty()) {
            return false;  // Invalid message
        }

        this.message = message;
        this.messageId = generateMessageID();

        // Build the full message string to store
        String fullMessage = "ID: " + messageId + " | To: " + recipientCell + " | Message: " + message;
        sentMessages.add(fullMessage);

        return true;
    }

    // --- NEW METHOD ---
    // Returns a formatted String listing all sent messages
    public String printMessages() {
        if (sentMessages.isEmpty()) {
            return "No messages have been sent yet.";
        }

        StringBuilder sb = new StringBuilder("Sent Messages:\n");
        for (int i = 0; i < sentMessages.size(); i++) {
            sb.append((i + 1)).append(". ").append(sentMessages.get(i)).append("\n");
        }
        return sb.toString();
        
        
    }
    // Returns the total number of messages sent
public int returnTotalMessages() {
    return sentMessages.size();
    
    

}


}
