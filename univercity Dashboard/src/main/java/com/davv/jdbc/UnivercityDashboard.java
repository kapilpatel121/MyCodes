package com.davv.jdbc;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;

import com.itextpdf.text.DocumentException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UnivercityDashboard extends Frame {
    private TextField usernameField;
    private TextField passwordField;
    private String actualPassword = "user@123"; // Actual password (replace with your actual password)

    private Button classAButton;
    private Button classBButton;
    private Button classCButton; // New button for Teacher Details

    public UnivercityDashboard() {
        setTitle("Login Form");
        setSize(400, 200); // Increased width to accommodate the new button
        setLayout(new BorderLayout());

        Panel loginPanel = new Panel();
        loginPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add padding around components

        Label usernameLabel = new Label("Username:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        loginPanel.add(usernameLabel, gbc);

        usernameField = new TextField(20); // Adjust width
        gbc.gridx = 1;
        gbc.gridy = 0;
        loginPanel.add(usernameField, gbc);

        Label passwordLabel = new Label("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        loginPanel.add(passwordLabel, gbc);

        passwordField = new TextField(20); // Adjust width
        passwordField.setEchoChar('*'); // To mask password
        gbc.gridx = 1;
        gbc.gridy = 1;
        loginPanel.add(passwordField, gbc);

        Button loginButton = new Button("Login");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Span across two columns
        loginPanel.add(loginButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                // Compare user input password with the actual password
                if (username.equals("DX2201500") && password.equals("user@123")) {
                    System.out.println("Login successful for username: " + username);
                    // Enable the Class A, Class B, and Class C buttons
                    classAButton.setEnabled(true);
                    classBButton.setEnabled(true);
                    classCButton.setEnabled(true);
                } else {
                    System.out.println("Invalid username or password");
                    // Disable the Class A, Class B, and Class C buttons
                    classAButton.setEnabled(false);
                    classBButton.setEnabled(false);
                    classCButton.setEnabled(false);
                }
            }
        });

        // Initialize Class A, Class B, and Class C buttons as disabled
        classAButton = new Button("Placement Record");
        classAButton.setEnabled(false);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        loginPanel.add(classAButton, gbc);

        classAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Code to execute when Class A button is clicked
                    new placementReport().generatePlacementRecordPDF();
                } catch (IOException ex) {
                    Logger.getLogger(UnivercityDashboard.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
                    Logger.getLogger(UnivercityDashboard.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(UnivercityDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("new PlacementRecord.generatePlacementRecordPDF()");
                // Replace the print statement with code to execute Class A
            }
        });

        classBButton = new Button("Student Result");
        classBButton.setEnabled(false);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        loginPanel.add(classBButton, gbc);

        classBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Code to execute when Class B button is clicked
                    new StudentResult().generateStudentResultPDF();
                } catch (IOException | DocumentException | SQLException e1) {
                    e1.printStackTrace();
                }
                System.out.println("new Student_Result().createPdf()");
                // Replace the print statement with code to execute Class B
            }
        });

        classCButton = new Button("Teacher Details"); // New button for Teacher Details
        classCButton.setEnabled(false);
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        loginPanel.add(classCButton, gbc);

        classCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Code to execute when Class C button is clicked
                	new Teacherdetails().createPdf();
                } catch (IOException | DocumentException | SQLException e1) {
                    e1.printStackTrace();
                }
                System.out.println("new Teacherdetails().createPdf()");
            }
        });

        add(loginPanel, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        UnivercityDashboard loginTab = new UnivercityDashboard();
        loginTab.setVisible(true);
    }
}
