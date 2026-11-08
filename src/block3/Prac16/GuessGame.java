package block3.Prac16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GuessGame extends JFrame {

    private JTextField guessField;
    private JButton guessButton;
    private JLabel infoLabel;

    private int secretNumber;
    private int attempts = 0;

    public GuessGame() {

        super("Guess Game");

        secretNumber = new Random().nextInt(21);

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        add(new JLabel("Угадайте число от 0 до 20:"));

        guessField = new JTextField(10);
        add(guessField);

        guessButton = new JButton("Угадать");
        add(guessButton);

        infoLabel = new JLabel("У вас 3 попытки");
        add(infoLabel);

        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        setVisible(true);
    }

    private void checkGuess() {

        if (attempts >= 3) {
            return;
        }

        String text = guessField.getText().trim();

        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Введите число!"
            );
            return;
        }

        int guess;

        try {
            guess = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Введите целое число от 0 до 20!"
            );
            return;
        }

        if (guess < 0 || guess > 20) {
            JOptionPane.showMessageDialog(
                    this,
                    "Число должно быть от 0 до 20!"
            );
            return;
        }

        attempts++;

        if (guess == secretNumber) {

            JOptionPane.showMessageDialog(
                    this,
                    "Вы угадали! Загаданное число: " + secretNumber
            );

            guessField.setEnabled(false);
            guessButton.setEnabled(false);
            infoLabel.setText("Игра завершена");

            return;
        }

        if (guess < secretNumber) {

            JOptionPane.showMessageDialog(
                    this,
                    "Неверно. Загаданное число больше."
            );

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Неверно. Загаданное число меньше."
            );
        }

        int remaining = 3 - attempts;

        if (remaining == 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Попытки закончились. Загаданное число: "
                            + secretNumber
            );

            guessField.setEnabled(false);
            guessButton.setEnabled(false);
            infoLabel.setText("Игра завершена");

        } else {

            infoLabel.setText(
                    "Осталось попыток: " + remaining
            );
        }

        guessField.setText("");
    }

    public static void main(String[] args) {
        new GuessGame();
    }
}