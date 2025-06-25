// Full Java Messaging App with Required Arrays and Functionalities
package com.mycompany.prog.poe;

import javax.swing.*;
import java.util.*;

class Message {
    private String id;
    private String text;
    private String sender;
    private String recipient;

    public Message(String id, String text, String sender, String recipient) {
        this.id = id;
        this.text = text;
        this.sender = sender;
        this.recipient = recipient;
    }

    public String getId() { return id; }
    public String getText() { return text; }
    public String getSender() { return sender; }
    public String getRecipient() { return recipient; }

    @Override
    public String toString() {
        return "[" + id + "] From: " + sender + " To: " + recipient + " - " + text;
    }

    public static String generateUniqueId() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 10) sb.append(rand.nextInt(10));
        return sb.toString();
    }
}

public class Login {
    private String registeredUsername;
    private String registeredPassword;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    private boolean accountCreated = false;
    private boolean isLoggedIn = false;
    private String loginStatus = "";

    private int messageLimit = 0;

    private ArrayList<Message> sentMessages = new ArrayList<>();
    private ArrayList<String> disregardedMessages = new ArrayList<>();
    private ArrayList<Message> storedMessages = new ArrayList<>();
    private ArrayList<String> messageHashes = new ArrayList<>();
    private ArrayList<String> messageIDs = new ArrayList<>();

    public Login() {}

    public void start() {
        while (true) {
            String[] options = {"Create Account", "Login"};
            int choice = JOptionPane.showOptionDialog(null, "Welcome! What would you like to do?", "Account Options",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == 0) {
                JOptionPane.showMessageDialog(null, registerUser());
            } else if (choice == 1) {
if (!accountCreated) {
    JOptionPane.showMessageDialog(null, "No account exists. Create an account first.", "Error", JOptionPane.ERROR_MESSAGE);
} else {
    loginUser();
    if (isLoggedIn) {
        JOptionPane.showMessageDialog(null, "Welcome " + firstName + " " + lastName);
        JOptionPane.showMessageDialog(null, "Welcome to QuickChat");
    } else {
        JOptionPane.showMessageDialog(null, loginStatus); // show "Login failed" message
    }
}

    loginUser();
    if (isLoggedIn) {
        JOptionPane.showMessageDialog(null, "Welcome " + firstName + " " + lastName);
        JOptionPane.showMessageDialog(null, "Welcome to QuickChat");
    } else {
        JOptionPane.showMessageDialog(null, loginStatus); // show "Login failed" message
    
}

            } else {
                JOptionPane.showMessageDialog(null, "Exiting program. Goodbye!");
                System.exit(0);
            }
        }
    }
    // ----- Helper Methods for Unit Testing -----

public void registerTestUser(String firstName, String lastName, String username, String password, String phone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.registeredUsername = username;
    this.registeredPassword = password;
    this.phoneNumber = phone;
    this.accountCreated = true;
}

public void setMessageLimit(int limit) {
    this.messageLimit = limit;
}

public void sendTestMessage(String text, String recipient) {
    String messageId = Message.generateUniqueId();
    Message msg = new Message(messageId, text, registeredUsername, recipient);
    sentMessages.add(msg);
    messageIDs.add(messageId);
    messageHashes.add(computeMessageHash(messageId, sentMessages.size(), text)); // FIXED
}


public List<Message> getSentMessages() {
    return sentMessages;
}

public List<String> getSentMessageTexts() {
    List<String> list = new ArrayList<>();
    for (Message m : sentMessages) list.add(m.getText());
    return list;
}

public String getLongestMessageText() {
    Message longest = null;
    for (Message m : sentMessages) {
        if (longest == null || m.getText().length() > longest.getText().length()) longest = m;
    }
    return longest != null ? longest.getText() : "";
}

public String searchByIdTest(String id) {
    for (Message m : sentMessages) {
        if (m.getId().equals(id)) {
            return "Recipient: " + m.getRecipient() + "\nMessage: " + m.getText();
        }
    }
    return "Message ID not found.";
}

public List<String> searchByRecipientTest(String recipient) {
    List<String> matches = new ArrayList<>();
    for (Message m : sentMessages) {
        if (m.getRecipient().equals(recipient)) matches.add(m.getText());
    }
    return matches;
}

public String deleteByHashTest(String hash) {
    for (int i = 0; i < sentMessages.size(); i++) {
        Message m = sentMessages.get(i);
        String computedHash = computeMessageHash(m.getId(), i + 1, m.getText()); // ✅ updated call
        if (computedHash.equals(hash)) {
            sentMessages.remove(i);
            return "Message \"" + m.getText() + "\" successfully deleted.";
        }
    }
    return "Hash not found.";
}


public String generateReport() {
    StringBuilder sb = new StringBuilder("Full Sent Message Report:\n");
    int index = 1;
    for (Message m : sentMessages) {
        String hash = computeMessageHash(m.getId(), index, m.getText()); // ✅ updated call
        sb.append("Message #").append(index++).append(": ")
          .append("Sender: ").append(m.getSender())
          .append(", Recipient: ").append(m.getRecipient())
          .append(", ID: ").append(m.getId())
          .append(", HASH: ").append(hash)
          .append(", Text: ").append(m.getText()).append("\n");
    }
    return sb.toString();
}


public String computeMessageHash(String id, int index, String text) {
    String[] words = text.split(" ");
    return (id.substring(0, 2) + ":" + index + ":" + words[0] + words[words.length - 1]).toUpperCase();
}



    public String registerUser() {
        firstName = JOptionPane.showInputDialog("Enter First Name:");
        lastName = JOptionPane.showInputDialog("Enter Last Name:");
        registeredUsername = JOptionPane.showInputDialog("Create Username (include '_' and max 5 characters):");

        if (!isUsernameValid(registeredUsername)) return "Invalid username.";

        registeredPassword = JOptionPane.showInputDialog("Create Password (8+ chars, 1 capital, 1 number, 1 special):");
        if (!isPasswordValid(registeredPassword)) return "Invalid password.";

        phoneNumber = JOptionPane.showInputDialog("Enter SA Phone Number (+27...):");
        if (!isValidRecipientNumber(phoneNumber)) return "Invalid phone number.";

        accountCreated = true;
        return "Account registered successfully!";
    }

    public boolean isUsernameValid(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean isPasswordValid(String password) {
        boolean upper = false, digit = false, special = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) upper = true;
            else if (Character.isDigit(c)) digit = true;
            else if (!Character.isLetterOrDigit(c)) special = true;
        }
        return password.length() >= 8 && upper && digit && special;
    }

    public boolean isValidRecipientNumber(String phone) {
        return phone.matches("\\+27\\d{9}");
    }

    public void loginUser() {
        String user = JOptionPane.showInputDialog("Enter Username:");
        String pass = JOptionPane.showInputDialog("Enter Password:");

        if (user.equals(registeredUsername) && pass.equals(registeredPassword)) {
            loginStatus = "Login successful! Welcome " + firstName + " " + lastName;
            isLoggedIn = true;
            messageLimit = Integer.parseInt(JOptionPane.showInputDialog("Set message limit:"));
            showMainMenu();
        } else {
            loginStatus = "Login failed.";
        }
    }

    public void showMainMenu() {
        while (true) {
            String input = JOptionPane.showInputDialog("Choose an option:\n" +
                    "1. Send Message\n" +
                    "2. Show Messages\n" +
                    "3. Quit");

            if (input == null) return;

            switch (input) {
                case "1": sendMessage(); break;
                case "2": showMessageOptions(); break;
                case "3": System.exit(0); break;
                default: JOptionPane.showMessageDialog(null, "Invalid choice.");
            }
        }
    }

    public void sendMessage() {
        if (sentMessages.size() >= messageLimit) {
            JOptionPane.showMessageDialog(null, "Message limit reached.");
            return;
        }

        String recipient = JOptionPane.showInputDialog("Enter recipient number (+27...):");
        if (!isValidRecipientNumber(recipient)) return;

        String messageText = JOptionPane.showInputDialog("Enter your message (max 250 chars):");
        if (messageText == null || messageText.length() > 250) return;

        String[] options = {"Send", "Disregard", "Store"};
        int choice = JOptionPane.showOptionDialog(null, messageText, "Options",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        String messageId = Message.generateUniqueId();
        String hash = (messageId.substring(0, 2) + ":" + (sentMessages.size() + 1) + ":" + messageText.split(" ")[0] + messageText.split(" ")[messageText.split(" ").length - 1]).toUpperCase();

        switch (choice) {
            case 0:
                Message msg = new Message(messageId, messageText, registeredUsername, recipient);
                sentMessages.add(msg);
                messageIDs.add(messageId);
                messageHashes.add(hash);
                JOptionPane.showMessageDialog(null, "Sent! ID: " + messageId + "\nHASH: " + hash);
                break;
            case 1:
                disregardedMessages.add(messageText);
                JOptionPane.showMessageDialog(null, "Message disregarded.");
                break;
            case 2:
                storedMessages.add(new Message(messageId, messageText, registeredUsername, recipient));
                JOptionPane.showMessageDialog(null, "Stored for later.");
                break;
        }
    }

    public void showMessageOptions() {
        StringBuilder sb = new StringBuilder("All Messages:\n\nSent:\n");
        for (Message m : sentMessages) sb.append(m).append("\n");
        sb.append("\nStored:\n");
        for (Message m : storedMessages) sb.append(m).append("\n");
        sb.append("\nDisregarded:\n");
        for (String m : disregardedMessages) sb.append(m).append("\n");

        JOptionPane.showMessageDialog(null, sb.toString());

        String input = JOptionPane.showInputDialog("Choose an option:\n" +
                "1. Display Sender & Recipient\n" +
                "2. Display Longest Message\n" +
                "3. Search by Message ID\n" +
                "4. Search by Recipient\n" +
                "5. Delete by Message Hash\n" +
                "6. Full Report\n" +
                "7. Back");

        switch (input) {
            case "1": displaySenderRecipient(); break;
            case "2": displayLongestMessage(); break;
            case "3": searchByID(); break;
            case "4": searchByRecipient(); break;
            case "5": DeleteByHash(); break;
            case "6": showFullReport(); break;
            case "7": return;
            default: JOptionPane.showMessageDialog(null, "Invalid choice.");
        }
    }

    public void displaySenderRecipient() {
        StringBuilder sb = new StringBuilder("Senders and Recipients:\n");
        for (Message m : sentMessages) sb.append("From: ").append(m.getSender()).append(" To: ").append(m.getRecipient()).append("\n");
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public void displayLongestMessage() {
        Message longest = null;
        for (Message m : sentMessages) {
            if (longest == null || m.getText().length() > longest.getText().length()) longest = m;
        }
        JOptionPane.showMessageDialog(null, longest != null ? longest.toString() : "No messages found.");
    }

    public void searchByID() {
        String id = JOptionPane.showInputDialog("Enter Message ID:");
        for (Message m : sentMessages) {
            if (m.getId().equals(id)) {
                JOptionPane.showMessageDialog(null, "Recipient: " + m.getRecipient() + "\nMessage: " + m.getText());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Message ID not found.");
    }

    public void searchByRecipient() {
        String target = JOptionPane.showInputDialog("Enter recipient number:");
        StringBuilder sb = new StringBuilder("Messages to " + target + ":\n");
        for (Message m : sentMessages) {
            if (m.getRecipient().equals(target)) sb.append(m).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public void DeleteByHash() {
        String hash = JOptionPane.showInputDialog("Enter Message Hash:");
        for (int i = 0; i < sentMessages.size(); i++) {
            String id = sentMessages.get(i).getId();
            String computedHash = (id.substring(0, 2) + ":" + (i + 1) + ":" + sentMessages.get(i).getText().split(" ")[0] + sentMessages.get(i).getText().split(" ")[sentMessages.get(i).getText().split(" ").length - 1]).toUpperCase();
            if (computedHash.equals(hash)) {
                sentMessages.remove(i);
                JOptionPane.showMessageDialog(null, "Message deleted.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Hash not found.");
    }

    public void showFullReport() {
        StringBuilder sb = new StringBuilder("Full Sent Message Report:\n");
        int index = 1;
        for (Message m : sentMessages) {
            String id = m.getId();
            String hash = (id.substring(0, 2) + ":" + index + ":" + m.getText().split(" ")[0] + m.getText().split(" ")[m.getText().split(" ").length - 1]).toUpperCase();
            sb.append("Message #").append(index++).append(": ")
              .append("Sender: ").append(m.getSender())
              .append(", Recipient: ").append(m.getRecipient())
              .append(", ID: ").append(m.getId())
              .append(", HASH: ").append(hash)
              .append(", Text: ").append(m.getText()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public static void main(String[] args) {
        new Login().start();
    }
}
