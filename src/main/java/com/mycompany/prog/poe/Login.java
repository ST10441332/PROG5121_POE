

package com.mycompany.prog.poe;

//import org.json.JSONArray;
//import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Random;

/*public void saveMessagesToJsonFile() {
    StringBuilder json = new StringBuilder();
    json.append("[\n");

    for (int i = 0; i < messages.size(); i++) {
        json.append("  ").append(messages.get(i).toJson());
        if (i < messages.size() - 1) {
            json.append(",");
        }
        json.append("\n");
    }

    json.append("]");

    try (FileWriter writer = new FileWriter("messages.json")) {
        writer.write(json.toString());
        JOptionPane.showMessageDialog(null, "Messages saved to messages.json");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error saving messages: " + e.getMessage());
    }
}*/
class Message {
    private String id;
    private String text;

    public Message(String id, String text) {
        this.id = id;
        this.text = text;
    }
public String toJson() {
    return String.format("{\"id\": \"%s\", \"text\": \"%s\"}", id, text.replace("\"", "\\\""));
}
    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + text;
    }

    // Generate unique 10-digit ID
    public static String generateUniqueId() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 10) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }
}

//I used openAI.(2025).Claude3.7 sonnet(Helped me build and fix my code)[https://chatgpt.com/c/680f809f-0ffc-8002-8231-22ef883ffeaf]
//I used openAI.(2025).Claude3.7 sonnet(Helped me change the code to use JOptionPane)[https://chatgpt.com/c/680f809f-0ffc-8002-8231-22ef883ffeaf]
//I used openAI.(2025).Claude3.7 sonnet(Helped me add return options)[https://chatgpt.com/c/680f809f-0ffc-8002-8231-22ef883ffeaf]
public class Login {
    private String registeredUsername;
    private String registeredPassword;
    private String firstName;
    private String lastName;
    
    private boolean accountCreated = false;
    private String loginStatus = "";
    private String phoneNumber;
    private ArrayList<Message> messages = new ArrayList<>();
    private boolean isLoggedIn = false;
    private int messageLimit = 0;
     private boolean messageLimitSet = false;
     private int messageCount = 0;
    
    // Constructor
    public Login(String username, String password, String phoneNumber) {
        this.registeredUsername = username;
        this.registeredPassword = password;
        this.phoneNumber = phoneNumber;
    }
    // Default constructor (for GUI use)
    public Login() {
    }
    public boolean isValidRecipientNumber(String phoneNumber) {
    return phoneNumber != null && phoneNumber.matches("\\+27\\d{9}");
}


    // Getters and Setters
    public String getUsername() {
        return registeredUsername;
    }

    public void setUsername(String username) {
        this.registeredUsername = username;
    }

    public String getPassword() {
        return registeredPassword;
    }

    public void setPassword(String password) {
        this.registeredPassword = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
// Username validation
    public boolean isUsernameValid() {
        return registeredUsername != null &&
               registeredUsername.contains("_") &&
               registeredUsername.length() <= 5;
    }

    // Password complexity validation
    public boolean checkPasswordComplexity() {
        return checkPasswordComplexity(registeredPassword).startsWith("Password successfully captured.");
    }
/*
    public String checkPasswordComplexity(String password) {
        boolean hasUpper = false, hasDigit = false, hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }

        if (password.length() >= 8 && hasUpper && hasDigit && hasSpecial) {
            return "Password successfully captured.";
        } else {
            return "Password is not correctly formatted.";
        }
    }*/
public Boolean checkCellPhoneNumber() {
    return checkCellPhoneNumber(this.phoneNumber);
}

    
//I used openAI.(2025).Claude3.7 sonnet(Creating the user to choice to login or create account)[https://chatgpt.com/c/680f809f-0ffc-8002-8231-22ef883ffeaf]
    public void start() {
        while (true) {
            String[] options = {"Create Account", "Login"};
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Welcome! What would you like to do?",
                    "Account Options",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (choice == 0) {
                String registrationMessage = registerUser();
                JOptionPane.showMessageDialog(null, registrationMessage);
            } else if (choice == 1) {
                if (!accountCreated) {
                    JOptionPane.showMessageDialog(null, "No account exists yet! Please create an account first then come back to continue.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    loginUser();
                    JOptionPane.showMessageDialog(null, returnLoginStatus());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Exiting program. Goodbye!");
                System.exit(0);
            }
        }
    }
//I used openAI.(2025).Claude3.7 sonnet(The username needs to contain an underscore and 5 charcters and state a message that the user name is ok to create the account and a message stating it can not be used)[https://chatgpt.com/c/680f809f-0ffc-8002-8231-22ef883ffeaf]
    // Checks username format
    public String checkUsername(String username) {
        if (username.contains("_") && username.length() <= 5) {
            return "Username is correctly formatted.";
        } else {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
    }

    public boolean isUsernameValid(String username) {
        return username.contains("_") && username.length() <= 5;
    }
//I used openAI.(2025).Claude3.7 sonnet(The password meets all conditions and shows message that its successful or not.)[https://chatgpt.com/c/680f809f-0ffc-8002-8231-22ef883ffeaf]
    // Checks password complexity
    public String checkPasswordComplexity(String password) {
        boolean hasUpper = false, hasDigit = false, hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }

        if (password.length() >= 8 && hasUpper && hasDigit && hasSpecial) {
            return "Password successfully captured.";
        } else {
            return "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
    }

    public boolean isPasswordValid(String password) {
        boolean hasUpper = false, hasDigit = false, hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }

        return password.length() >= 8 && hasUpper && hasDigit && hasSpecial;
    }
//I used openAI.(2025).Claude3.7 sonnet(Ask the user to put their South African phone number)[https://chatgpt.com/c/680f809f-0ffc-8002-8231-22ef883ffeaf]
   //I used openAI.(2025).Claude3.7 sonnet(The phone number contains international country code ,no more than 10 characters long.)[https://chatgpt.com/c/680f809f-0ffc-8002-8231-22ef883ffeaf]
    public Boolean checkCellPhoneNumber(String phone) {
        return phone != null && phone.matches("\\+27\\d{9}");
    }

    public String registerUser() {
        firstName = JOptionPane.showInputDialog(null, "Enter your First Name:");
        if (firstName == null) return "Registration terminated.";

        lastName = JOptionPane.showInputDialog(null, "Enter your Last Name:");
        if (lastName == null) return "Registration terminated.";

        registeredUsername = JOptionPane.showInputDialog(null, "Create your Username (must contain '_' and max 5 characters):");
        if (registeredUsername == null) return "Registration terminated.";

        String usernameFeedback = checkUsername(registeredUsername);
        JOptionPane.showMessageDialog(null, usernameFeedback);

        if (!isUsernameValid(registeredUsername)) {
            return "Registration failed due to invalid username.";
        }

        registeredPassword = JOptionPane.showInputDialog(null, "Create your Password (8+ chars, 1 capital letter, 1 number, 1 special char):");
        if (registeredPassword == null) return "Registration terminated.";

        String passwordFeedback = checkPasswordComplexity(registeredPassword);
        JOptionPane.showMessageDialog(null, passwordFeedback);

        if (!isPasswordValid(registeredPassword)) {
            return "Registration failed due to invalid password.";
        }

        String phone = JOptionPane.showInputDialog(null, "Enter your South African phone number (e.g. +27821234567):");
        if (phone == null) return "Registration terminated.";

        if (!checkCellPhoneNumber(phone)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        this.phoneNumber = phone;
        accountCreated = true;
        return "Registration successful!";
    }
//I used openAI.(2025).Claude3.7 sonnet(Login account uses the same username and password,the entered username and password are correct and the user will be greeted and show there name and surname)[https://chatgpt.com/c/680f809f-0ffc-8002-8231-22ef883ffeaf]
    public Boolean loginUser() {
        String usernameInput = JOptionPane.showInputDialog(null, "Login - Enter your Username:");
        String passwordInput = JOptionPane.showInputDialog(null, "Login - Enter your Password:");

        if (usernameInput == null || passwordInput == null) {
            loginStatus = "Login cancelled.";
            isLoggedIn = false;
            return false;
        }

        if (usernameInput.equals(registeredUsername) && passwordInput.equals(registeredPassword)) {
            loginStatus = "Login successful - Welcome " + firstName + " " + lastName;
            isLoggedIn = true;
             setMessageLimit();
            showMenuAfterLogin(); //  Launch menu after login
            return true;
        } else {
            loginStatus = "Login failed - Incorrect username or password.";
            isLoggedIn = false;
            return false;
        }
        
    }
    public void saveMessagesToJsonFile(String filename) {
 
}
    

         public void setMessageLimit() {
        while (true) {
            String limitInput = JOptionPane.showInputDialog(null, "How many messages do you want to send?");
            if (limitInput == null) {
                JOptionPane.showMessageDialog(null, "No input received. Defaulting to 0 messages.");
                messageLimit = 0;
                break;
            }

            if (limitInput.matches("\\d+")) {
                messageLimit = Integer.parseInt(limitInput);
                messageLimitSet = true;
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
            }
        }
    }
     //New method: Feature menu shown after successful login
    public void showMenuAfterLogin() {
        JOptionPane.showMessageDialog(null, "Welcome to QuickChat");

        while (true) {
            String input = JOptionPane.showInputDialog(null,
                    "Please select an option:\n" +
                    "1. Send Message\n" +
"2. Show Recently Sent Messages\n" +
//"3. Delete Message by ID\n" +
//"4. Save Messages to File\n" +
"3. Quit"
, JOptionPane.PLAIN_MESSAGE);

            if (input == null) {
                JOptionPane.showMessageDialog(null, "Returning to main menu.");
                break;
            }

            switch (input.trim()) {
                case "1":
    if (messages.size() >= messageLimit) {
        JOptionPane.showMessageDialog(null, "You have reached your message limit.");
        break;
    }

    String recipient = JOptionPane.showInputDialog(null, "Enter recipient phone number (e.g. +27821234567):");
    if (!isValidRecipientNumber(recipient)) {
        JOptionPane.showMessageDialog(null, "Invalid recipient phone number format.");
        break;
    }

    String messageText = JOptionPane.showInputDialog(null, "Enter your message (Max 250 characters):");
    if (messageText != null && !messageText.trim().isEmpty()) {
        if (messageText.length() > 250) {
            JOptionPane.showMessageDialog(null, "Please enter a message of less than 250 characters.");
            break;
        }

       String[] sendOptions = {"Send Message", "Disregard Message", "Store to Send Later"};
int sendChoice = JOptionPane.showOptionDialog(
    null,
    "What would you like to do with this message?\n" + messageText,
    "Message Options",
    JOptionPane.DEFAULT_OPTION,
    JOptionPane.QUESTION_MESSAGE,
    null,
    sendOptions,
    sendOptions[0]
);

switch (sendChoice) {
    case 0: // Send Message
        messageCount++;
        String numberedMessage = "Message " + messageCount + ": " + messageText;
        String messageId = Message.generateUniqueId();
        messages.add(new Message(messageId, numberedMessage));

        // Generate hash
        String firstTwoDigits = messageId.substring(0, 2);
        String[] words = messageText.trim().split("\\s+");
        String firstWord = words[0];
        String lastWord = words[words.length -1];//i commetec -1 out
        String hash = (firstTwoDigits + ":" + messageCount + ":" + firstWord + lastWord).toUpperCase();

        JOptionPane.showMessageDialog(null, "Message sent!\nID: " + messageId + "\nHASH: " + hash);
        break;

    case 1: // Disregard Message
        JOptionPane.showMessageDialog(null, "Message was disregarded and not saved.");
        break;

    case 2: // Store to Send Later
        String messageIdLater = Message.generateUniqueId();
        String storedMessage = "[Stored] Message: " + messageText;
        messages.add(new Message(messageIdLater, storedMessage));
        JOptionPane.showMessageDialog(null, "Message stored to send later.\nID: " + messageIdLater);
        break;

    default:
        JOptionPane.showMessageDialog(null, "No action taken.");
}

    }
    break;


                case "2":
    if (messages.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Coming ");
    } else {
        StringBuilder recentMessages = new StringBuilder("Most Recent Messages:\n");
        int start = Math.max(0, messages.size() - 5);
        for (int i = start; i < messages.size(); i++) {
            Message msg = messages.get(i); // Assuming Message is your custom class
            recentMessages.append(messages.get(i)).append("\n");
//recentMessages.append((i + 1)).append(". ")
                         // .append("ID: ").append(msg.getId()).append(" - ")
                          //.append(msg.getContent()).append("\n");
        }
        JOptionPane.showMessageDialog(null, recentMessages.toString());

        int confirm = JOptionPane.showConfirmDialog(null, "Do you want to delete a message?", "Delete Message", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String deleteId = JOptionPane.showInputDialog(null, "Enter the 10-digit Message ID to delete:");
            if (deleteId != null) {
                boolean found = false;
                for (int i = 0; i < messages.size(); i++) {
                    if (messages.get(i).getId().equals(deleteId)) {
                        messages.remove(i);
                        JOptionPane.showMessageDialog(null, "Message with ID " + deleteId + " deleted.");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(null, "No message found with ID " + deleteId + ".");
                }
            }
        }
    }
    break;

                
    /*case "4":
    saveMessagesToJsonFile("messages.json");
    break;*/

                case "3":
 //saveMessagesToJsonFile(); // Save before exit
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please choose 1, 2 or 3.");
              
            }
        }
    }

    public String returnLoginStatus() {
        return loginStatus;
    }

    public static void main(String[] args) {
        Login app = new Login();
        app.start();
    }
}