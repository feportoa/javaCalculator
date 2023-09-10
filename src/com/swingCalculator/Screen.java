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
        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;

        setTitle("JaCa");

        int roundScrWidth, roundScrHeight;
        roundScrWidth = Math.round(scrWidth);
        roundScrHeight = Math.round(scrHeight);
        setSize(roundScrWidth, roundScrHeight);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(grid);

        /* ---------- Visual Elements ---------- */
        JLabel operationLabel = new JLabel("Test");
        operationLabel.setFont(new Font("Arial", Font.BOLD, 32));

        gbc.weightx = 0.5;
        gbc.weighty = 0.5;

        gbc.gridx = 0;
        gbc.gridwidth = 3;

        gbc.gridy = 0;
        gbc.gridheight = 2;

        gbc.fill = GridBagConstraints.BOTH;
        add(operationLabel, gbc);

        JButton[] btnArray = new JButton[15];

        JButton del = stylizedButtons("del", true);
        JButton multiply = stylizedButtons("*", true);
        JButton divide = stylizedButtons("/", true);
        JButton sub = stylizedButtons("-", true);
        JButton decimalSeparator = stylizedButtons(".", true);

        JButton add = stylizedButtons("+", false);
        gbc.gridx = 3;
        gbc.gridwidth = 1;

        gbc.gridy = 2;
        gbc.gridheight = 2;

        gbc.fill = GridBagConstraints.BOTH;
        add(add, gbc);

        JButton res = stylizedButtons("=", false);
        gbc.gridx = 3;
        gbc.gridwidth = 1;

        gbc.gridy = 4;
        gbc.gridheight = 3;

        gbc.fill = GridBagConstraints.BOTH;
        add(res, gbc);

        JButton btn1 = stylizedButtons("1", true);
        JButton btn2 = stylizedButtons("2", true);
        JButton btn3 = stylizedButtons("3", true);
        JButton btn4 = stylizedButtons("4", true);
        JButton btn5 = stylizedButtons("5", true);
        JButton btn6 = stylizedButtons("6", true);
        JButton btn7 = stylizedButtons("7", true);
        JButton btn8 = stylizedButtons("8", true);
        JButton btn9 = stylizedButtons("9", true);
        JButton btn0 = stylizedButtons("0", true);

        btnArray[0] = divide;
        btnArray[1] = multiply;
        btnArray[2] = sub;
        btnArray[3] = btn1;
        btnArray[4] = btn2;
        btnArray[5] = btn3;
        btnArray[6] = btn4;
        btnArray[7] = btn5;
        btnArray[8] = btn6;
        btnArray[9] = btn7;
        btnArray[10] = btn8;
        btnArray[11] = btn9;
        btnArray[12] = del;
        btnArray[13] = btn0;
        btnArray[14] = decimalSeparator;

        gridConfig(btnArray, gbc, 0, 2, 2, 6);

        setVisible(true);
    }

    private JButton stylizedButtons(String label, boolean isAdded)
    {
        JButton btn = new JButton(label);
        btn.setPreferredSize(new Dimension(50, 50));
        btn.setFont(new Font("Arial", Font.PLAIN, 18));
        btn.setForeground(new Color(0x3F3F3F));
        btn.setBackground(new Color(0xDFDFDF));
        btn.setBorder(BorderFactory.createLineBorder(new Color(0xAFAFAF)));
        btn.setFocusPainted(false);
        btn.setHorizontalTextPosition(JButton.CENTER);
        btn.setVerticalTextPosition(JButton.CENTER);

        if(isAdded) {
            GridBagConstraints gbcVar = new GridBagConstraints();
            gbcVar.weightx = 0.1;
            gbcVar.weighty = 0.1;
            add(btn,gbcVar);
        }

        return btn;
    }

    private void gridConfig(JButton[] buttonArray, GridBagConstraints gbcVar, int startGridx, int endGridx, int startGridy, int endGridy)
    {
        int buttonArrayCount = 0;

        for(int i = startGridy; i <= endGridy; i++){
            for(int j = startGridx; j <= endGridx; j++){
                if(buttonArrayCount < buttonArray.length) {
                    gbcVar.gridx = j;
                    gbcVar.gridwidth = 1;

                    gbcVar.gridy = i;
                    gbcVar.gridheight = 1;

                    gbcVar.fill = GridBagConstraints.BOTH;

                    add(buttonArray[buttonArrayCount], gbcVar);
                    buttonArrayCount++;
                }
            }
        }
    }
}
