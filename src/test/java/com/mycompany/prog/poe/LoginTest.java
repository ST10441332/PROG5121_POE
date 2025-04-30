package com.mycompany.prog.poe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
//I used openAI.(2025).Claude3.7 sonnet(Helped me fix my test unit)[https://chatgpt.com/c/680f809f-0ffc-8002-8231-22ef883ffeaf]
public class LoginTest {

    private static final String validUsername = "kyl_";
    private static final String invalidUsername = "kyle!!";
    private static final String validPassword = "Chr&3bny";
    private static final String invalidPassword = "password";
    private static final String validPhoneNumber = "+27838968976";
    private static final String invalidPhoneNumber = "08966553";

    @Test
    public void testGetUsername() {
        Login instance = new Login(validUsername, validPassword, validPhoneNumber);
        assertEquals(validUsername, instance.getUsername());
    }

    @Test
    public void testSetUsername() {
        Login instance = new Login(validUsername, validPassword, validPhoneNumber);
        String newUsername = "new_";
        instance.setUsername(newUsername);
        assertEquals(newUsername, instance.getUsername());
    }

    @Test
    public void testGetPassword() {
        Login instance = new Login(validUsername, validPassword, validPhoneNumber);
        assertEquals(validPassword, instance.getPassword());
    }

    @Test
    public void testSetPassword() {
        Login instance = new Login(validUsername, validPassword, validPhoneNumber);
        String newPassword = "C4mh@c!";
        instance.setPassword(newPassword);
        assertEquals(newPassword, instance.getPassword());
    }

    @Test
    public void testGetPhoneNumber() {
        Login instance = new Login(validUsername, validPassword, validPhoneNumber);
        assertEquals(validPhoneNumber, instance.getPhoneNumber());
    }

    @Test
    public void testSetPhoneNumber() {
        Login instance = new Login(validUsername, validPassword, validPhoneNumber);
        String newPhone = "+27987654321";
        instance.setPhoneNumber(newPhone);
        assertEquals(newPhone, instance.getPhoneNumber());
    }

    @Test
    public void testIsUsernameValid() {
        Login validInstance = new Login(validUsername, validPassword, validPhoneNumber);
        assertTrue(validInstance.isUsernameValid());

        Login invalidInstance = new Login(invalidUsername, validPassword, validPhoneNumber);
        assertFalse(invalidInstance.isUsernameValid());
    }

    @Test
    public void testCheckPasswordComplexity() {
        Login validInstance = new Login(validUsername, validPassword, validPhoneNumber);
        assertTrue(validInstance.checkPasswordComplexity());

        Login shortPasswordInstance = new Login(validUsername, "Pass1!", validPhoneNumber);
        assertFalse(shortPasswordInstance.checkPasswordComplexity());
    }
/*
    @Test
    public void testCheckCellPhoneNumber() {
        Login validInstance = new Login(validUsername, validPassword, validPhoneNumber);
        assertTrue(validInstance.checkCellPhoneNumber());

        Login invalidInstance = new Login(validUsername, validPassword, invalidPhoneNumber);
        assertFalse(invalidInstance.checkCellPhoneNumber());
    }

    @Test
    public void testLoginUser() {
        Login instance = new Login(validUsername, validPassword, validPhoneNumber);

        assertTrue(instance.loginUser(validUsername, validPassword, validPhoneNumber));
        assertFalse(instance.loginUser("wrong_", validPassword, validPhoneNumber));
        assertFalse(instance.loginUser(validUsername, "wrongPass", validPhoneNumber));
        assertFalse(instance.loginUser(validUsername, validPassword, "wrongPhone"));
        */
   /* @Test
    public void testCheckCellPhoneNumber() {
        System.out.println("checkCellPhoneNumber");
        Login validInstance = new Login(validUsername,validPassword,validPhoneNumber);
        assertTrue(validInstance.checkPasswordComplexity());
        
        Login noCodeInstance = new Login(validUsername,validPassword,"88966553");
        assertFalse(noCodeInstance.checkCellPhoneNumber());
    }

    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        Login instance = new Login(validUsername,validPassword,validPhoneNumber);
        
        boolean successResult = instance.loginUser(validUsername,validPassword,validPhoneNumber);
        assertTrue(successResult);
        
        boolean wrongUsernameResult = instance.loginUser("kyle!!!",validPassword,validPhoneNumber);
        assertFalse(wrongUsernameResult);
        
        boolean wrongPasswordResult = instance.loginUser(validUsername,"password!",validPhoneNumber);
        assertFalse(wrongPasswordResult);*/
    
    //I used openAI.(2025).Claude3.7 sonnet(Helped me fix the last section of my unit test and what to add to my Login.java file.)[https://chatgpt.com/c/680f809f-0ffc-8002-8231-22ef883ffeaf]
 @Test
public void testCheckCellPhoneNumber() {
    System.out.println("checkCellPhoneNumber");
    
    Login validInstance = new Login(validUsername, validPassword, validPhoneNumber);
    assertTrue(validInstance.checkCellPhoneNumber()); //  Correct method

    Login noCodeInstance = new Login(validUsername, validPassword, "88966553");
    assertFalse(noCodeInstance.checkCellPhoneNumber()); //  Also correct
}


    }

