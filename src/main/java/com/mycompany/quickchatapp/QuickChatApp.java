/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quickchatapp;

/**
 * The Independent Institute of Education (IIE) - Varsity College
 *
 * @author lab_services_student
 */


import javax.swing.*;

public class QuickChatApp {

    public static void main(String[] args) {
        // Registration
        String registeredUsername = JOptionPane.showInputDialog("Register - Enter a new username:");
        String registeredPassword = JOptionPane.showInputDialog("Register - Enter a new password:");

        JOptionPane.showMessageDialog(null, "Registration successful! Please log in.");

        // Login
        String username;
        String password;
        boolean loggedIn = false;

        for (int i = 0; i < 3; i++) { // Allow 3 attempts
            username = JOptionPane.showInputDialog("Login - Enter your username:");
            password = JOptionPane.showInputDialog("Login - Enter your password:");

            if (username.equals(registeredUsername) && password.equals(registeredPassword)) {
                loggedIn = true;
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.");
            }
        }

        if (!loggedIn) {
            JOptionPane.showMessageDialog(null, "Too many failed attempts. Exiting...");
            return;
        }

        JOptionPane.showMessageDialog(null, "Welcome to QuickChat!");

        int totalMessagesSent = 0;
        Message[] messages;

        int msgCount = Integer.parseInt(JOptionPane.showInputDialog("How many messages would you like to send?"));
        messages = new Message[msgCount];

        int menuOption;
        do {
            String menu = """
                          Please select an option:
                          1) Send Messages
                          2) Show recently sent messages
                          3) Quit""";
            menuOption = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (menuOption) {
                case 1 -> {
                    for (int i = 0; i < msgCount; i++) {
                        Message msg = new Message(i);
                        msg.captureMessageDetails();
                        String result = msg.sendMessageOption();
                        JOptionPane.showMessageDialog(null, result);

                        if (msg.wasSent()) {
                            JOptionPane.showMessageDialog(null, msg.printMessages());
                            totalMessagesSent++;
                        }

                        messages[i] = msg;
                    }
                    JOptionPane.showMessageDialog(null, "Total messages sent: " + totalMessagesSent);
                }

                case 2 -> JOptionPane.showMessageDialog(null, "Coming Soon.");

                case 3 -> JOptionPane.showMessageDialog(null, "Goodbye!");

                default -> JOptionPane.showMessageDialog(null, "Invalid option. Try again.");
            }
        } while (menuOption != 3);
    }
}

