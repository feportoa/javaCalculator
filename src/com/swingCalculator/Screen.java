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
    public Screen()
    {
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

        JButton BTest = new JButton("Test");
        Font font = new Font("Arial", Font.BOLD, 18);
        Color foregroundColor = new Color(203, 203, 203);
        Color backgroundColor = new Color(31, 31, 31);

        BTest.setBounds(Math.round((scrWidth/2f)-(btnWidth/2f)), Math.round(btnHeight*0.2f), Math.round(btnWidth), Math.round(btnHeight));
        BTest.setFont(new Font("Arial", Font.BOLD, 14));
        BTest.setForeground(new Color(203, 203, 203));
        BTest.setBackground(new Color(31, 31, 31));


        JButton BTest2 = new JButton("Test 2");
        BTest2.setBounds(Math.round((scrWidth/2f)-(btnWidth/2f)), Math.round((roundScrHeight - btnHeight*1.7f)), Math.round(btnWidth), Math.round(btnHeight));
        BTest2.setFont(new Font("Arial", Font.BOLD, 18));
        BTest2.setForeground(new Color(203, 203, 203));
        BTest2.setBackground(new Color(31, 31, 31));

        add(BTest);
        add(BTest2);

        BTest.addActionListener(this::secondTestMethod);
        BTest2.addActionListener(this::testMethod);

        userText = new JTextField("Your name here");
        userText.setBounds(Math.round(btnWidth), Math.round(btnHeight * 2f), 240, 150);
        userText.setFont(font);
        userText.requestFocusInWindow();

        add(userText);
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
