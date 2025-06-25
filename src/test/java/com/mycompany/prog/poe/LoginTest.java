package com.mycompany.prog.poe;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class LoginTest {
    private Login login;
    private String testRecipient = "+27838884567";

    @BeforeEach
    void setup() {
        login = new Login();
        login.registerTestUser("Priya", "Singh", "pri_", "Passw0rd!", testRecipient);
        login.setMessageLimit(10);

        login.sendTestMessage("Did you get the cake?", testRecipient);
        login.sendTestMessage("It is dinner time!", testRecipient);
        login.sendTestMessage("Ok, I am leaving without you.", testRecipient);
        login.sendTestMessage("Where are you? You are late! I have asked you to be on time.", testRecipient);
    }

    @Test
    void testSentMessagesArrayCorrectlyPopulated() {
        List<String> texts = login.getSentMessageTexts();
        assertTrue(texts.contains("Did you get the cake?"));
        assertTrue(texts.contains("It is dinner time!"));
    }

    @Test
    void testDisplayLongestMessage() {
        String longest = login.getLongestMessageText();
        assertEquals("Where are you? You are late! I have asked you to be on time.", longest);
    }

    @Test
    void testSearchByMessageID() {
        String messageId = login.getSentMessages().get(3).getId();  // 4th message
        String result = login.searchByIdTest(messageId);
        assertTrue(result.contains("It is dinner time!")); // Fixed recipient check
    }

    @Test
    void testSearchByRecipient() {
        List<String> results = login.searchByRecipientTest(testRecipient);
        assertTrue(results.contains("Where are you? You are late! I have asked you to be on time."));
        assertTrue(results.contains("Ok, I am leaving without you."));
    }

    @Test
    void testDeleteByHash() {
        Message msg = login.getSentMessages().get(3); // Get 4th message
        String hash = login.computeMessageHash(msg.getId(), 4, msg.getText()); // Correct ID + index
        String result = login.deleteByHashTest(hash);
        assertTrue(result.contains("successfully deleted"));
    }

    @Test
    void testFullReportContainsExpectedValues() {
        String report = login.generateReport();
        assertTrue(report.contains(" Message HASH"));
        assertTrue(report.contains("Recipient"));
        assertTrue(report.contains("Message"));
    }
}
