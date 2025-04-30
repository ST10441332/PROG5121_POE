package com.mycompany.prog.poe;

import javax.swing.JOptionPane;
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
    
    // Constructor
    public Login(String username, String password, String phoneNumber) {
        this.registeredUsername = username;
        this.registeredPassword = password;
        this.phoneNumber = phoneNumber;
    }
    // Default constructor (for GUI use)
    public Login() {
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

        accountCreated = true;
        return "Registration successful!";
    }
//I used openAI.(2025).Claude3.7 sonnet(Login account uses the same username and password,the entered username and password are correct and the user will be greeted and show there name and surname)[https://chatgpt.com/c/680f809f-0ffc-8002-8231-22ef883ffeaf]
    public Boolean loginUser() {
        String usernameInput = JOptionPane.showInputDialog(null, "Login - Enter your Username:");
        String passwordInput = JOptionPane.showInputDialog(null, "Login - Enter your Password:");

        if (usernameInput == null || passwordInput == null) {
            loginStatus = "Login cancelled.";
            return false;
        }

        if (usernameInput.equals(registeredUsername) && passwordInput.equals(registeredPassword)) {
            loginStatus = "Login successful - Welcome " + firstName + " " + lastName;
            return true;
        } else {
            loginStatus = "Login failed - Incorrect username or password.";
            return false;
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
 
