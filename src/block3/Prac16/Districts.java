package block3.Prac16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Districts extends JFrame {

    public Districts() {

        super("Округа");

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // NORTH
        JLabel north = createLabel("NORTH");
        north.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(
                        Districts.this,
                        "Добро пожаловать в САО"
                );
            }
        });

        // SOUTH
        JLabel south = createLabel("SOUTH");
        south.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(
                        Districts.this,
                        "Добро пожаловать ЮАО"
                );
            }
        });

        // WEST
        JLabel west = createLabel("WEST");
        west.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(
                        Districts.this,
                        "Добро пожаловать в ЗАО"
                );
            }
        });

        // EAST
        JLabel east = createLabel("EAST");
        east.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(
                        Districts.this,
                        "Добро пожаловать в ВАО"
                );
            }
        });

        // CENTER
        JLabel center = createLabel("CENTER");
        center.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(
                        Districts.this,
                        "Добро пожаловать в ЦАО"
                );
            }
        });

        // Добавляем области в BorderLayout
        add(north, BorderLayout.NORTH);
        add(south, BorderLayout.SOUTH);
        add(west, BorderLayout.WEST);
        add(east, BorderLayout.EAST);
        add(center, BorderLayout.CENTER);

        setVisible(true);
    }

    // Создание надписи для каждой области
    private JLabel createLabel(String text) {

        JLabel label = new JLabel(text, SwingConstants.CENTER);

        label.setOpaque(true);
        label.setBackground(Color.LIGHT_GRAY);

        label.setBorder(
                BorderFactory.createLineBorder(Color.BLACK)
        );

        label.setPreferredSize(
                new Dimension(120, 80)
        );

        return label;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> new Districts()
        );
    }
}
