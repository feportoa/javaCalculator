package com.swingCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Screen extends JFrame
{
    JTextField userText;
    long scrWidth = 480L;
    long scrHeight = 600L;
    long btnWidth = 100L;
    long btnHeight = 75L;

    Font font = new Font("Arial", Font.BOLD, 18);
    Color foregroundColor = new Color(203, 203, 203);
    Color backgroundColor = new Color(31, 31, 31);

    public Screen()
    {
        /* ---------- Screen Settings ---------- */
        setTitle("JaCa");
        setVisible(true);

        int roundScrWidth, roundScrHeight;
        roundScrWidth = Math.round(scrWidth);
        roundScrHeight = Math.round(scrHeight);
        setSize(roundScrWidth, roundScrHeight);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        /* ---------- Visual Elements ---------- */

        JButton BTest = Button("Test Title", Math.round((scrWidth/2f)-(btnWidth/2f)), Math.round(btnHeight*0.2f), Math.round(btnWidth), Math.round(btnHeight));
        JButton BTest2 = Button("Test 2", Math.round((scrWidth/2f)-(btnWidth/2f)), Math.round((roundScrHeight - btnHeight*1.7f)), Math.round(btnWidth), Math.round(btnHeight));

        userText = TextInput("Type your name here!", Math.round(btnWidth), Math.round(btnHeight * 2f), 240, 150);

        add(BTest);
        add(BTest2);

        add(userText);

        BTest.addActionListener(this::secondTestMethod);
        BTest2.addActionListener(this::testMethod);

    }

    private JButton Button(String buttonName, int x, int y, int width, int height)
    {
        JButton Button = new JButton(buttonName);

        Button.setBounds(x, y, width, height);
        Button.setFont(new Font("Arial", Font.BOLD, 14));
        Button.setForeground(new Color(203, 203, 203));
        Button.setBackground(new Color(31, 31, 31));

        return Button;
    }

    private JTextField TextInput(String placeholderText, int x, int y, int width, int height)
    {
        userText = new JTextField(placeholderText);
        userText.setBounds(x, y, width, height);
        userText.setFont(font);
        userText.requestFocusInWindow();

        return userText;
    }

    private void testMethod(ActionEvent actionEvent)
    {
        JOptionPane.showMessageDialog(null, "BTest2 clicked - WORKING", "Test message confirmation", JOptionPane.ERROR_MESSAGE);
    }

    private void secondTestMethod(ActionEvent actionEvent)
    {
        String userInput = JOptionPane.showInputDialog("Type something :)!", "Somthing");
        if(userInput != null && userInput.equals("something :)!")){
            JOptionPane.showMessageDialog(null, ("Interesting choice, " + userText.getText() + "!"), "Wise choice path...", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}