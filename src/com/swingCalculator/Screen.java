package com.swingCalculator;

import javax.swing.*;
import java.awt.*;
import java.util.Deque;
import java.util.ArrayDeque;

public class Screen extends JFrame
{
    Deque<Double> num = new ArrayDeque<>();
    Deque<String> constOperators = new ArrayDeque<>();
    Deque<String> operators = new ArrayDeque<>();
    String numString;

    JLabel operationLabel;

    long scrWidth = 480L;
    long scrHeight = 600L;

    public Screen()
    {
        constOperators.add("+");
        constOperators.add("-");
        constOperators.add("*");
        constOperators.add("/");

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
        operationLabel = new JLabel(); // Holds 21 characters (min)
        operationLabel.setFont(new Font("Arial", Font.BOLD, 32));

        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        gbc.gridx = 0;
        gbc.gridwidth = 4;

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

        /* ------------ Math config ------------ */

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

        btn.addActionListener(e -> composeOperation((JButton) e.getSource()));

        if(isAdded) {
            GridBagConstraints gbcVar = new GridBagConstraints();
            gbcVar.weightx = 0.1;
            gbcVar.weighty = 0.1;
            add(btn,gbcVar);
        }

        return btn;
    }

    private void composeOperation(JButton event){
        String jLabelString = operationLabel.getText();
        if(event.getText().equals("del")) {
            operationLabel.setText(jLabelString.substring(0, jLabelString.length() - 1));
        } else if(event.getText().equals("=")){
            del(operationLabel);
            num.add(Double.parseDouble(jLabelString));
            calculate();
            operators.clear();
            num.clear();
        } else if(constOperators.contains(event.getText())) {
            del(operationLabel);
            if(!jLabelString.isEmpty()) {
                num.add(Double.parseDouble(jLabelString));
            }
            operators.add(event.getText());
        } else {
            concatNumber(event.getText());
        }
    }

    private void del(JLabel lbl)
    {
        lbl.setText(null);
    }

    private void concatNumber(String digit)
    {
        operationLabel.setText(operationLabel.getText() == null ? digit : operationLabel.getText() + digit);
        numString += digit;
    }

    private void calculate()
    {
        double res = 0;
        for(int i = 0; i < operators.size(); i++){
            double n1 = num.getFirst();
            num.pop();
            double n2 = num.getFirst();
            num.pop();

            switch(operators.getFirst()){
                case "+":
                    res = n1 + n2;
                    num.addFirst(res);
                    break;

                case "-":
                    res = n1 - n2;
                    num.addFirst(res);
                    break;

                case "*":
                    res = n1 * n2;
                    num.addFirst(res);
                    break;

                case "/":
                    res = n1 / n2;
                    num.addFirst(res);
                    break;
            }
            operators.pop();
            --i;
        }
        operationLabel.setText(Double.toString(res));
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
