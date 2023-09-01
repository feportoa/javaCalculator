import java.util.Scanner;
import java.util.Locale;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        boolean isRunning = true;
        int res = 0;

        do {
            System.out.println("N1: ");
            int n1 = scan.nextInt();

            System.out.println("\nOperator: ");
            char op = scan.next().charAt(0);

            System.out.println("\nN2: ");
            int n2 = scan.nextInt();

            switch (op) {
                case '+':
                    res = n1 + n2;
                    isRunning = false;
                    break;

                case '-':
                    res = n1 - n2;
                    isRunning = false;
                    break;

                case '*':
                    res = n1 * n2;
                    isRunning = false;
                    break;

                case '/':
                    res = n1 / n2;
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid value");
            }
        } while(isRunning);

        System.out.println("Result: " + res);
    }
}