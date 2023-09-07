package com.swingCalculator;

import javax.swing.*;
import java.awt.*;
import java.math.RoundingMode;

public class Screen extends JFrame
{
    float scrWidth = 480;
    float scrHeight = 600;
    float btnWidth = 100;
    float btnHeight = 75;
    public Screen()
    {
        setTitle("JaCa");
        setVisible(true);
        int roundScrWidth, roundScreHeight;
        roundScrWidth = Math.round(scrWidth);
        roundScreHeight = Math.round(scrHeight);
        setSize(roundScrWidth, roundScreHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        JButton btn = new JButton("Teste");
        btn.setBounds(Math.round((scrWidth/2)-(btnWidth/2)), Math.round(btnHeight*0.2f), Math.round(btnWidth), Math.round(btnHeight));

        add(btn);
    }
}
