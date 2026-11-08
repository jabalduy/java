package block3.Prac16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextStyleMenu extends JFrame {

    private JTextArea textArea;

    public TextStyleMenu() {

        super("Text Style Menu");

        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Текстовая область
        textArea = new JTextArea();

        textArea.setText(
                "Введите здесь текст.\n" +
                        "Через меню можно изменить его цвет и шрифт."
        );

        textArea.setFont(
                new Font("Times New Roman", Font.PLAIN, 18)
        );

        add(new JScrollPane(textArea), BorderLayout.CENTER);


        // =========================
        // СТРОКА МЕНЮ
        // =========================

        JMenuBar menuBar = new JMenuBar();


        // =========================
        // МЕНЮ "ЦВЕТ"
        // =========================

        JMenu colorMenu = new JMenu("Цвет");

        JMenuItem blueItem =
                new JMenuItem("Синий");

        JMenuItem redItem =
                new JMenuItem("Красный");

        JMenuItem blackItem =
                new JMenuItem("Черный");


        colorMenu.add(blueItem);
        colorMenu.add(redItem);
        colorMenu.add(blackItem);


        // Синий цвет
        blueItem.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        textArea.setForeground(Color.BLUE);
                    }
                }
        );


        // Красный цвет
        redItem.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        textArea.setForeground(Color.RED);
                    }
                }
        );


        // Черный цвет
        blackItem.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        textArea.setForeground(Color.BLACK);
                    }
                }
        );


        // =========================
        // МЕНЮ "ШРИФТ"
        // =========================

        JMenu fontMenu = new JMenu("Шрифт");

        JMenuItem timesItem =
                new JMenuItem("Times New Roman");

        JMenuItem sansItem =
                new JMenuItem("MS Sans Serif");

        JMenuItem courierItem =
                new JMenuItem("Courier New");


        fontMenu.add(timesItem);
        fontMenu.add(sansItem);
        fontMenu.add(courierItem);


        // Times New Roman
        timesItem.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        textArea.setFont(
                                new Font(
                                        "Times New Roman",
                                        Font.PLAIN,
                                        18
                                )
                        );
                    }
                }
        );


        // MS Sans Serif
        sansItem.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        textArea.setFont(
                                new Font(
                                        "MS Sans Serif",
                                        Font.PLAIN,
                                        18
                                )
                        );
                    }
                }
        );


        // Courier New
        courierItem.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        textArea.setFont(
                                new Font(
                                        "Courier New",
                                        Font.PLAIN,
                                        18
                                )
                        );
                    }
                }
        );


        // Добавляем оба меню
        menuBar.add(colorMenu);
        menuBar.add(fontMenu);

        setJMenuBar(menuBar);

        setVisible(true);
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> new TextStyleMenu()
        );
    }
}
