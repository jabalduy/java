package block3.Prac5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FootballScore extends JFrame {

    int milanScore = 0;
    int madridScore = 0;

    JLabel resultLabel;
    JLabel lastScorerLabel;
    JLabel winnerLabel;

    public FootballScore() {

        // Создание окна
        setTitle("Football Match");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Создание панели
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 5, 5));

        // Создание кнопок
        JButton milanButton = new JButton("AC Milan");
        JButton madridButton = new JButton("Real Madrid");

        // Создание надписей
        resultLabel = new JLabel("Result: 0 X 0", JLabel.CENTER);
        lastScorerLabel = new JLabel("Last Scorer: N/A", JLabel.CENTER);
        winnerLabel = new JLabel("Winner: DRAW", JLabel.CENTER);

        // Нажатие на кнопку AC Milan
        milanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                milanScore++;

                resultLabel.setText(
                        "Result: " + milanScore + " X " + madridScore
                );

                lastScorerLabel.setText("Last Scorer: AC Milan");

                updateWinner();
            }
        });

        // Нажатие на кнопку Real Madrid
        madridButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                madridScore++;

                resultLabel.setText(
                        "Result: " + milanScore + " X " + madridScore
                );

                lastScorerLabel.setText("Last Scorer: Real Madrid");

                updateWinner();
            }
        });

        // Добавление элементов на панель
        panel.add(resultLabel);
        panel.add(lastScorerLabel);
        panel.add(winnerLabel);
        panel.add(milanButton);
        panel.add(madridButton);

        // Добавление панели в окно
        add(panel);

        // Показываем окно
        setVisible(true);
    }

    // Метод определения победителя
    public void updateWinner() {

        if (milanScore > madridScore) {
            winnerLabel.setText("Winner: AC Milan");
        }
        else if (madridScore > milanScore) {
            winnerLabel.setText("Winner: Real Madrid");
        }
        else {
            winnerLabel.setText("Winner: DRAW");
        }
    }

    public static void main(String[] args) {
        new FootballScore();
    }
}