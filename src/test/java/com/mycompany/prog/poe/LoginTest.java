package com.mycompany.prog.poe;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
//I used openAI.(2025).Claude3.7 sonnet(Helped me fix my test unit)[https://chatgpt.com/c/680f809f-0ffc-8002-8231-22ef883ffeaf]
public class LoginTest {

    private static final String validUsername = "kyl_";
    private static final String invalidUsername = "kyle!!";
    private static final String validPassword = "Chr&3bny";
    private static final String invalidPassword = "password";
    private static final String validPhoneNumber = "+27838968976";
    private static final String invalidPhoneNumber = "08966553";

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

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

    /**
     * Test of isValidRecipientNumber method, of class Login.
     */
    @Test
    public void testIsValidRecipientNumber() {
        System.out.println("isValidRecipientNumber");
        String phoneNumber = "";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.isValidRecipientNumber(phoneNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isUsernameValid method, of class Login.
     */
    @Test
    public void testIsUsernameValid_0args() {
        System.out.println("isUsernameValid");
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.isUsernameValid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPasswordComplexity method, of class Login.
     */
    @Test
    public void testCheckPasswordComplexity_0args() {
        System.out.println("checkPasswordComplexity");
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkPasswordComplexity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkCellPhoneNumber method, of class Login.
     */
    @Test
    public void testCheckCellPhoneNumber_0args() {
        System.out.println("checkCellPhoneNumber");
        Login instance = new Login();
        Boolean expResult = null;
        Boolean result = instance.checkCellPhoneNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class Login.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Login instance = new Login();
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUsername method, of class Login.
     */
    @Test
    public void testCheckUsername() {
        System.out.println("checkUsername");
        String username = "";
        Login instance = new Login();
        String expResult = "";
        String result = instance.checkUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isUsernameValid method, of class Login.
     */
    @Test
    public void testIsUsernameValid_String() {
        System.out.println("isUsernameValid");
        String username = "";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.isUsernameValid(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPasswordComplexity method, of class Login.
     */
    @Test
    public void testCheckPasswordComplexity_String() {
        System.out.println("checkPasswordComplexity");
        String password = "";
        Login instance = new Login();
        String expResult = "";
        String result = instance.checkPasswordComplexity(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPasswordValid method, of class Login.
     */
    @Test
    public void testIsPasswordValid() {
        System.out.println("isPasswordValid");
        String password = "";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.isPasswordValid(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkCellPhoneNumber method, of class Login.
     */
    @Test
    public void testCheckCellPhoneNumber_String() {
        System.out.println("checkCellPhoneNumber");
        String phone = "";
        Login instance = new Login();
        Boolean expResult = null;
        Boolean result = instance.checkCellPhoneNumber(phone);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerUser method, of class Login.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        Login instance = new Login();
        String expResult = "";
        String result = instance.registerUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loginUser method, of class Login.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        Login instance = new Login();
        Boolean expResult = null;
        Boolean result = instance.loginUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveMessagesToJsonFile method, of class Login.
     */
    @Test
    public void testSaveMessagesToJsonFile() {
        System.out.println("saveMessagesToJsonFile");
        String filename = "";
        Login instance = new Login();
        instance.saveMessagesToJsonFile(filename);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMessageLimit method, of class Login.
     */
    @Test
    public void testSetMessageLimit() {
        System.out.println("setMessageLimit");
        Login instance = new Login();
        instance.setMessageLimit();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showMenuAfterLogin method, of class Login.
     */
    @Test
    public void testShowMenuAfterLogin() {
        System.out.println("showMenuAfterLogin");
        Login instance = new Login();
        instance.showMenuAfterLogin();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnLoginStatus method, of class Login.
     */
    @Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        Login instance = new Login();
        String expResult = "";
        String result = instance.returnLoginStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Login.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Login.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
    //I used openAI.(2025).Claude3.7 sonnet(Helped me fix the last section of my unit test and what to add to my Login.java file.)[https://chatgpt.com/c/680f809f-0ffc-8002-8231-22ef883ffeaf]
 