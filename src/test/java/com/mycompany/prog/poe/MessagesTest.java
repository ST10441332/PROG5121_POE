package com.mycompany.prog.poe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessagesTest {

    public MessagesTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        String recipient = "+27689087654";
        Messages instance = new Messages();
        boolean expResult = true;
        boolean result = instance.checkRecipientCell(recipient);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckMessageID() {
        System.out.println("checkMessageID");
        String messageID = "0000987654";
        Messages instance = new Messages();
        boolean expResult = true;
        boolean result = instance.checkMessageID(messageID);
        assertEquals(expResult, result);
    }

    @Test
    public void testGenerateMessageID() {
        System.out.println("generateMessageID");
        Messages instance = new Messages();
        String result = instance.generateMessageID();
        assertNotNull(result);  // we expect some ID to be generated
        assertTrue(result.matches("\\d+"));  // Check if it's numeric
    }

    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        String messageId = "001234567890";
        int messageNumber = 0;
        String messageBody = "Hi Mike, can you join us for dinner Tonight";
        Messages instance = new Messages();
        String expResult = "00:0:HiTonight";
        String result = instance.createMessageHash(messageId, messageNumber, messageBody);
        assertEquals(expResult, result);
    }

    @Test
    public void testSendMessage() {
        System.out.println("sendMessage");
        String message = "Test message";
        Messages instance = new Messages();
        boolean result = instance.sendMessage(message);
        assertTrue(result);  // If your implementation sends it properly
    }

    @Test
    public void testPrintMessages() {
        System.out.println("printMessages");
        Messages instance = new Messages();
        String result = instance.printMessages();
        assertNotNull(result);  // You can improve this if you know the expected output
    }

    @Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");
        Messages instance = new Messages();
        int result = instance.returnTotalMessages();
        assertTrue(result >= 0);  // Should be 0 or more
    }
}
