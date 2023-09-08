package com.swingCalculator;

import javax.swing.*;
import java.awt.*;

public class VisualElements
{
    JTextField userText;

    Font btnFont, inputFont, labelFont;
    Color btnForegroundColor, btnBackgroundColor, inputForegroundColor, inputBackgroundColor;

    int x, y, width, height;

    public VisualElements()
    {
        userText = new JTextField();

        btnFont = new Font("Arial", Font.BOLD, 18);
        inputFont = new Font("Arial", Font.PLAIN, 14);
        labelFont = new Font("Arial", Font.PLAIN, 12);

        btnForegroundColor = new Color(203, 203, 203);
        btnBackgroundColor = new Color(31, 31, 31);
        inputBackgroundColor = new Color(200, 200, 200);
        inputForegroundColor = new Color(55, 55, 55);
    }

    protected JButton Button(String buttonText)
    {
        JButton Button = new JButton(buttonText);
        Button.setBounds(x, y, width, height);
        Button.setForeground(btnForegroundColor);
        Button.setBackground(btnBackgroundColor);

        return Button;
    }

    protected JTextField TextInput(String inputPlaceholder)
    {
        userText = new JTextField(inputPlaceholder);
        userText.setBounds(x, y, width, height);
        userText.setFont(inputFont);

        return userText;
    }

    protected JLabel StaticText(String textContent)
    {
        JLabel txt = new JLabel(textContent);
        txt.setBounds(x, y, width, height);
        txt.setFont(labelFont);

        return txt;
    }
}
