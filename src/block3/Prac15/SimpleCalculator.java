package block3.Prac15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {

    private JTextField display;

    private JButton[] numberButtons = new JButton[10];

    private JButton addButton;
    private JButton subButton;
    private JButton mulButton;
    private JButton divButton;
    private JButton equalButton;
    private JButton clearButton;
    private JButton dotButton;

    private double num1 = 0;
    private char operator = '\0';

    // Максимальное количество символов на экране
    private final int MAX_LENGTH = 15;

    // Показывает, был ли только что получен результат
    private boolean resultShown = false;


    public SimpleCalculator() {

        super("Calculator");

        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Поле вывода
        display = new JTextField();

        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);

        add(display, BorderLayout.NORTH);


        // Панель кнопок
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(5, 4, 5, 5));


        // Цифровые кнопки
        for (int i = 0; i < 10; i++) {

            numberButtons[i] =
                    new JButton(String.valueOf(i));

            numberButtons[i].addActionListener(this);
        }


        // Кнопки операций
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");

        equalButton = new JButton("=");
        clearButton = new JButton("C");
        dotButton = new JButton(".");


        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);

        equalButton.addActionListener(this);
        clearButton.addActionListener(this);
        dotButton.addActionListener(this);


        // Расположение кнопок
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(divButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(mulButton);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(subButton);

        panel.add(numberButtons[0]);
        panel.add(dotButton);
        panel.add(equalButton);
        panel.add(addButton);

        panel.add(clearButton);

        add(panel, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();


        // =========================
        // ВВОД ЦИФР
        // =========================

        for (int i = 0; i < 10; i++) {

            if (source == numberButtons[i]) {

                // Если перед этим был показан результат,
                // начинаем ввод нового числа
                if (resultShown) {

                    display.setText("");

                    resultShown = false;
                    operator = '\0';
                }

                // Ограничиваем длину числа
                if (display.getText().length() < MAX_LENGTH) {

                    display.setText(
                            display.getText() + i
                    );
                }

                return;
            }
        }


        // =========================
        // ТОЧКА
        // =========================

        if (source == dotButton) {

            if (resultShown) {

                display.setText("0.");
                resultShown = false;
                operator = '\0';

                return;
            }

            // Нельзя поставить две точки
            if (display.getText().contains(".")) {
                return;
            }

            // Если число еще не введено,
            // получаем 0.
            if (display.getText().isEmpty()) {

                display.setText("0.");

            } else if (display.getText().length() < MAX_LENGTH) {

                display.setText(
                        display.getText() + "."
                );
            }

            return;
        }


        // =========================
        // ОЧИСТКА
        // =========================

        if (source == clearButton) {

            clearCalculator();

            return;
        }


        // =========================
        // ОПЕРАЦИИ
        // =========================

        if (source == addButton) {
            setOperator('+');
            return;
        }

        if (source == subButton) {
            setOperator('-');
            return;
        }

        if (source == mulButton) {
            setOperator('*');
            return;
        }

        if (source == divButton) {
            setOperator('/');
            return;
        }


        // =========================
        // РАВНО
        // =========================

        if (source == equalButton) {

            calculateResult();
        }
    }


    // Выбор арифметической операции
    private void setOperator(char newOperator) {

        // Если число еще не введено,
        // нажатие операции ничего не делает
        if (display.getText().isEmpty()
                || display.getText().equals("Error")) {

            return;
        }

        try {

            num1 = Double.parseDouble(
                    display.getText()
            );

            operator = newOperator;

            display.setText("");

            resultShown = false;

        } catch (NumberFormatException ex) {

            showError();
        }
    }


    // Вычисление результата
    private void calculateResult() {

        // Нельзя нажать "=" без операции
        if (operator == '\0') {
            return;
        }

        // Нельзя вычислять без второго числа
        if (display.getText().isEmpty()) {
            return;
        }

        try {

            double num2 =
                    Double.parseDouble(display.getText());

            double result;

            switch (operator) {

                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':

                    // Деление на ноль
                    if (num2 == 0) {

                        JOptionPane.showMessageDialog(
                                this,
                                "Division by zero is not allowed!",
                                "Error",
                                JOptionPane.ERROR_MESSAGE
                        );

                        clearCalculator();

                        return;
                    }

                    result = num1 / num2;
                    break;

                default:
                    return;
            }


            // Проверка слишком большого результата
            if (Double.isInfinite(result)
                    || Double.isNaN(result)) {

                JOptionPane.showMessageDialog(
                        this,
                        "The result is too large or incorrect!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );

                clearCalculator();

                return;
            }


            // Красиво выводим результат
            display.setText(formatResult(result));

            resultShown = true;

            // Операция закончена
            operator = '\0';


        } catch (NumberFormatException ex) {

            showError();
        }
    }


    // Убираем ненужное .0 у целых чисел
    private String formatResult(double result) {

        if (result == Math.floor(result)
                && Math.abs(result) < 1_000_000_000_000_000L) {

            return String.valueOf((long) result);
        }

        String text = String.valueOf(result);

        // Защита от слишком длинного результата
        if (text.length() > MAX_LENGTH) {

            return String.format("%.8g", result);
        }

        return text;
    }


    // Полная очистка калькулятора
    private void clearCalculator() {

        display.setText("");

        num1 = 0;

        operator = '\0';

        resultShown = false;
    }


    // Ошибка
    private void showError() {

        JOptionPane.showMessageDialog(
                this,
                "Incorrect number!",
                "Error",
                JOptionPane.ERROR_MESSAGE
        );

        clearCalculator();
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->
                new SimpleCalculator()
        );
    }
}