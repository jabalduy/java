package block3.Prac15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {

    private JTextField display = new JTextField();
    private JButton[] numbers = new JButton[10];
    private JButton plus = new JButton("+");
    private JButton minus = new JButton("-");
    private JButton multiply = new JButton("*");
    private JButton divide = new JButton("/");
    private JButton equal = new JButton("=");
    private JButton clear = new JButton("C");
    private JButton dot = new JButton(".");

    private double firstNumber = 0;
    private char operation = ' ';
    private boolean newNumber = false;
    private boolean resultShown = false;

    public SimpleCalculator() {
        super("Calculator");
        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(5, 4, 5, 5));
        for (int i = 0; i < 10; i++) {
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
        }

        JButton[] otherButtons = {plus, minus, multiply, divide, equal, clear, dot};
        for (JButton button : otherButtons) {
            button.addActionListener(this);
        }

        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(divide);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(multiply);
        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(minus);
        panel.add(numbers[0]);
        panel.add(dot);
        panel.add(equal);
        panel.add(plus);
        panel.add(clear);

        add(panel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == clear) {
            reset();
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (source == numbers[i]) {
                if (newNumber || resultShown) {
                    display.setText("");
                    newNumber = false;
                    resultShown = false;
                }
                if (display.getText().length() < 15) {
                    display.setText(display.getText() + i);
                }
                return;
            }
        }

        if (source == dot) {
            if (newNumber || resultShown) {
                display.setText("");
                newNumber = false;
                resultShown = false;
            }
            if (!display.getText().contains(".") && display.getText().length() < 15) {
                if (display.getText().isEmpty() || display.getText().equals("-")) {
                    display.setText(display.getText() + "0.");
                } else {
                    display.setText(display.getText() + ".");
                }
            }
            return;
        }

        if (source == equal) {
            if (operation != ' ' && !newNumber && !display.getText().isEmpty()) {
                calculate();
                operation = ' ';
                resultShown = true;
            }
            return;
        }

        char selected = ' ';
        if (source == plus) selected = '+';
        if (source == minus) selected = '-';
        if (source == multiply) selected = '*';
        if (source == divide) selected = '/';

        if (selected == ' ') return;

        // Минус в начале ввода означает отрицательное число.
        if (selected == '-' && (display.getText().isEmpty() || newNumber)) {
            display.setText("-");
            newNumber = false;
            return;
        }

        if (display.getText().isEmpty() || display.getText().equals("-")) return;

        if (operation != ' ' && !newNumber) {
            if (!calculate()) return;
        } else {
            firstNumber = Double.parseDouble(display.getText());
        }

        operation = selected;
        newNumber = true;
        resultShown = false;
    }

    private boolean calculate() {
        try {
            double secondNumber = Double.parseDouble(display.getText());
            double result;

            switch (operation) {
                case '+': result = firstNumber + secondNumber; break;
                case '-': result = firstNumber - secondNumber; break;
                case '*': result = firstNumber * secondNumber; break;
                case '/':
                    if (secondNumber == 0) {
                        showError("На ноль делить нельзя");
                        return false;
                    }
                    result = firstNumber / secondNumber;
                    break;
                default: return false;
            }

            if (!Double.isFinite(result)) {
                showError("Слишком большое число");
                return false;
            }

            firstNumber = result;
            if (result == (long) result && Math.abs(result) < 1e15) {
                display.setText(String.valueOf((long) result));
            } else {
                display.setText(String.valueOf(result));
            }
            return true;
        } catch (NumberFormatException ex) {
            showError("Некорректное число");
            return false;
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Ошибка", JOptionPane.ERROR_MESSAGE);
        reset();
    }

    private void reset() {
        display.setText("");
        firstNumber = 0;
        operation = ' ';
        newNumber = false;
        resultShown = false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleCalculator());
    }
}
