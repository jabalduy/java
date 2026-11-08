package block3.Prac15;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame {

    JTextField number1 = new JTextField(10);
    JTextField number2 = new JTextField(10);

    JButton addButton = new JButton("+");
    JButton subtractButton = new JButton("-");
    JButton multiplyButton = new JButton("*");
    JButton divideButton = new JButton("/");

    public Calculator() {

        super("Calculator");

        setLayout(new FlowLayout());
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("1st Number"));
        add(number1);

        add(new JLabel("2nd Number"));
        add(number2);

        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);

        // Сложение
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate("+");
            }
        });

        // Вычитание
        subtractButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate("-");
            }
        });

        // Умножение
        multiplyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate("*");
            }
        });

        // Деление
        divideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate("/");
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void calculate(String operation) {

        try {

            double x1 =
                    Double.parseDouble(number1.getText().trim());

            double x2 =
                    Double.parseDouble(number2.getText().trim());

            double result = 0;

            if (operation.equals("+")) {
                result = x1 + x2;
            }

            else if (operation.equals("-")) {
                result = x1 - x2;
            }

            else if (operation.equals("*")) {
                result = x1 * x2;
            }

            else if (operation.equals("/")) {

                if (x2 == 0) {
                    JOptionPane.showMessageDialog(
                            null,
                            "На ноль делить нельзя!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }

                result = x1 / x2;
            }

            JOptionPane.showMessageDialog(
                    null,
                    "Result = " + result,
                    "Result",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Введите корректные числа!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
