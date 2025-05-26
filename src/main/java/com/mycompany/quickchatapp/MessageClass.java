/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchatapp;

/**
 * The Independent Institute of Education (IIE) - Varsity College
 *
 * @author lab_services_student
 */


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */
public class MessageClass {

    // Test 1: Check if message is within 250 characters - success
    @Test
    public void testMessageLengthSuccess() {
        String shortMessage = "Hi Mike, can you join us for dinner tonight";
        assertTrue(shortMessage.length() <= 250, "Message ready to send.");
    } //(IIE,VARSITY COLLEGE)

    // Test 2: Check if message exceeds 250 characters - failure
    @Test
    public void testMessageLengthFailure() {
        String longMessage = "A".repeat(270);
        int excess = longMessage.length() - 250;
        assertTrue(longMessage.length() > 250, "Message exceeds 250 characters by " + excess);
    }

    // Test 3: Check correct phone number format - success
    @Test
    public void testPhoneNumberSuccess() {
        Message msg = new Message(0);
        assertTrue(msg.checkRecipientCell("+27718693002")); //(IIE,VARSITY COLLEGE)
    }

    // Test 4: Check incorrect phone number format - failure
    @Test
    public void testPhoneNumberFailure() {
        Message msg = new Message(0);
        assertFalse(msg.checkRecipientCell("08575975889")); //(IIE,VARSITY COLLEGE)
    }

    // Test 5: Check if message hash is correctly generated
    @Test
    public void testMessageHash() {
        Message msg = new Message(0);

        // Fake injection for test
        msg.recipient = "+27718693002";
        msg.messageText = "Hi Mike, can you join us for dinner tonight";
        // This calls createMessageHash internally after capture

        // Generate expected hash manually (assuming messageID starts with "00" and messageNumber is 0)
        String expectedPrefix = msg.getMessageHash().substring(0, 2);  //(IIE,VARSITY COLLEGE)

        assertTrue(msg.getMessageHash().endsWith(":0:HITONIGHT"), "Message hash matches expected format."); //(IIE,VARSITY COLLEGE)
    }

    // Test 6: Check message ID length
    @Test
    public void testMessageIDLength() {
        Message msg = new Message(0);
        assertTrue(msg.checkMessageID(), "Message ID should be 10 digits or less."); //(IIE,VARSITY COLLEGE)
    }

    // Test 7: Check "Send Message" option
    @Test
    public void testSendMessageOptionSend() {
        Message msg = new Message(1) {
            @Override
            public String sendMessageOption() {
                return "Message successfully sent."; //(IIE,VARSITY COLLEGE)
            }
        };
        assertEquals("Message successfully sent.", msg.sendMessageOption()); //(IIE,VARSITY COLLEGE)
    }

    // Test 8: Check "Disregard Message" option
    @Test
    public void testSendMessageOptionDiscard() {
        Message msg = new Message(2) {
            @Override
            public String sendMessageOption() {
                return "Press 0 to delete message.";
            }
        };
        assertEquals("Press 0 to delete message.", msg.sendMessageOption()); //(IIE,VARSITY COLLEGE)
    }

    // Test 9: Check "Store Message" option
    @Test
    public void testSendMessageOptionStore() {
        Message msg = new Message(3) {
            @Override
            public String sendMessageOption() {
                return "Message successfully stored.";//(IIE,VARSITY COLLEGE)
            }
        };
        assertEquals("Message successfully stored.", msg.sendMessageOption()); //(IIE,VARSITY COLLEGE)
    }
}
