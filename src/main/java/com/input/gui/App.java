package com.input.gui;

import javax.swing.*;
import java.awt.*;

public class App {
    private final JFrame frame;
    private final JPanel panel;

    private final int width;
    private final int height;

    private final JLabel userLabel;
    private final JTextField userInput;
    private final JLabel passwordLabel;
    private final JPasswordField passwordInput;
    private final JButton submitButton;
    private final JLabel loginMessage;

    private final int labelWidth;
    private final int labelHeight;
    private final int inputWidth;
    private final int inputHeight;
    private final int buttonWidth;
    private final int buttonHeight;

    private final int gap;

    public App(JFrame frame,
               JPanel panel,
               int width,
               int height,
               JLabel userLabel,
               JTextField userInput,
               JLabel passwordLabel,
               JPasswordField passwordInput,
               JButton submitButton,
               JLabel loginMessage,
               int labelWidth,
               int labelHeight,
               int inputWidth,
               int inputHeight,
               int buttonWidth,
               int buttonHeight,
               int gap) {

        this.frame = frame;
        this.panel = panel;
        this.width = width;
        this.height = height;

        this.userLabel = userLabel;
        this.userInput = userInput;
        this.passwordLabel = passwordLabel;
        this.passwordInput = passwordInput;
        this.submitButton = submitButton;
        this.loginMessage = loginMessage;

        this.labelWidth = labelWidth;
        this.labelHeight = labelHeight;

        this.inputWidth = inputWidth;
        this.inputHeight = inputHeight;

        this.buttonWidth = buttonWidth;
        this.buttonHeight = buttonHeight;

        this.gap = gap;
    }

    public static void main(String[] args) {
        var panel = new JPanel();
        var frame = new JFrame();

        var userLabel = new JLabel("User:");
        var userInput = new JTextField();

        var passwordLabel = new JLabel("Password:");
        var passwordInput = new JPasswordField();

        var submitButton = new JButton("submit");

        var loginMessage = new JLabel("test");

        var app = new App(frame, panel,
                1024, 680,
                userLabel, userInput,
                passwordLabel, passwordInput,
                submitButton,
                loginMessage,
                100, 40,
                160, 40,
                100, 40,
                20);

        app.set();
        app.run();
    }

    public void set() {
        userLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        userInput.setFont(new Font("Verdana", Font.PLAIN, 18));
        passwordLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        passwordInput.setFont(new Font("Verdana", Font.PLAIN, 18));
        submitButton.setFont(new Font("Verdana", Font.PLAIN, 18));
        loginMessage.setFont(new Font("Verdana", Font.PLAIN, 18));

        userInput.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        passwordInput.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        submitButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        submitButton.setForeground(Color.WHITE);
        submitButton.setBackground(Color.DARK_GRAY);

        loginMessage.setVisible(false);

        userLabel.setBounds(width/2-(labelWidth+inputWidth)/2, height/3, labelWidth, labelHeight);
        userInput.setBounds(width/2-(labelWidth+inputWidth)/2+labelWidth, height/3, inputWidth, inputHeight);
        passwordLabel.setBounds(width/2-(labelWidth+inputWidth)/2, height/3 + labelHeight + gap, labelWidth, labelHeight);
        passwordInput.setBounds(width/2-(labelWidth+inputWidth)/2+labelWidth, height/3 + labelHeight + gap, inputWidth, inputHeight);
        submitButton.setBounds(width/2 - buttonWidth/2, height/3 + labelHeight * 2 + gap + labelHeight + gap, buttonWidth, buttonHeight);
        loginMessage.setBounds(width/2 - labelWidth/2, height/3 + labelHeight * 2 + gap + labelHeight + gap + buttonHeight + gap, labelWidth, labelHeight);

        panel.add(userLabel);
        panel.add(userInput);
        panel.add(passwordLabel);
        panel.add(passwordInput);
        panel.add(submitButton);
        panel.add(loginMessage);

        panel.setLayout(null);

        submitButton.addActionListener(new SubmitController(this));
//        submitButton.addActionListener(this);

        frame.add(panel);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }

    public void run() {
        frame.setVisible(true);
    }

    public String getUser() {
        return userInput.getText();
    }

    public String getPassword() {
        return new String(passwordInput.getPassword());
    }

    public void loginSuccess() {
        loginMessage.setText("success");
        loginMessage.setForeground(Color.green);
    }

    public void loginFailure() {
        loginMessage.setText("failure");
        loginMessage.setForeground(Color.red);
    }

    public void showLoginMessage() {
        loginMessage.setVisible(true);
    }
}
