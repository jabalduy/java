package block3.Prac16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PasswordCheck extends JFrame {

    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel resultLabel;

    public PasswordCheck() {

        super("Проверка пароля");

        setSize(400, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Основная панель
        JPanel mainPanel = new JPanel();

        // GridLayout: 4 строки, 2 столбца
        mainPanel.setLayout(
                new GridLayout(4, 2, 10, 10)
        );

        // Поле логина
        JLabel loginLabel =
                new JLabel("Логин:");

        loginField =
                new JTextField();

        // Поле пароля
        JLabel passwordLabel =
                new JLabel("Пароль:");

        passwordField =
                new JPasswordField();

        // Кнопка
        loginButton =
                new JButton("Проверить");

        // Надпись результата
        resultLabel =
                new JLabel("");


        // Добавляем элементы
        mainPanel.add(loginLabel);
        mainPanel.add(loginField);

        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);

        mainPanel.add(new JLabel(""));
        mainPanel.add(loginButton);

        mainPanel.add(new JLabel("Результат:"));
        mainPanel.add(resultLabel);


        // Добавляем панель в окно
        add(mainPanel, BorderLayout.CENTER);


        // Обработка нажатия кнопки
        loginButton.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        checkPassword();
                    }
                }
        );


        // Можно нажать Enter в поле пароля
        passwordField.addActionListener(
                e -> checkPassword()
        );

        setVisible(true);
    }


    private void checkPassword() {

        String login =
                loginField.getText().trim();

        String password =
                new String(
                        passwordField.getPassword()
                );


        // Проверка пустых полей
        if (login.isEmpty()
                || password.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Введите логин и пароль!",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }


        // Правильные данные
        if (login.equals("Иван")
                && password.equals("1234")) {

            resultLabel.setText(
                    "Вход выполнен"
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Вход выполнен!"
            );

        } else {

            resultLabel.setText(
                    "Неверный логин или пароль"
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Вход НЕ выполнен!",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE
            );

            passwordField.setText("");
        }
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> new PasswordCheck()
        );
    }
}
