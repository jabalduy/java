package block3.Prac15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuExample extends JFrame {

    JTextArea textArea;
    JButton button1;
    JButton button2;

    public MenuExample() {

        super("Menu Example");

        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ---------- МЕНЮ ----------

        JMenuBar menuBar = new JMenuBar();

        // Меню File
        JMenu fileMenu = new JMenu("File");

        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        // Меню Edit
        JMenu editMenu = new JMenu("Edit");

        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem pasteItem = new JMenuItem("Paste");

        editMenu.add(copyItem);
        editMenu.add(cutItem);
        editMenu.add(pasteItem);

        // Меню Help
        JMenu helpMenu = new JMenu("Help");

        JMenuItem aboutItem = new JMenuItem("About");
        helpMenu.add(aboutItem);

        // Добавляем меню в строку меню
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        // ---------- КНОПКИ ----------

        JPanel buttonPanel = new JPanel();

        button1 = new JButton("Button 1");
        button2 = new JButton("Button 2");

        buttonPanel.add(button1);
        buttonPanel.add(button2);

        // ---------- ТЕКСТОВОЕ ПОЛЕ ----------

        textArea = new JTextArea();

        textArea.setText("This is the area you can write text.");

        add(buttonPanel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // ---------- ОБРАБОТЧИКИ ----------

        copyItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.copy();
            }
        });

        cutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.cut();
            }
        });

        pasteItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.paste();
            }
        });

        saveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(
                        null,
                        "Text saved!"
                );
            }
        });

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(
                        null,
                        "Simple Java menu program"
                );
            }
        });

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.append("\nButton 1 pressed");
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.append("\nButton 2 pressed");
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuExample();
    }
}
