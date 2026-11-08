package block3.Prac15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CountryMenu extends JFrame {

    JComboBox<String> countryBox;
    JLabel infoLabel;

    public CountryMenu() {

        super("Country Menu");

        setLayout(new FlowLayout());
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Список стран
        String[] countries = {
                "Australia",
                "China",
                "England",
                "Russia"
        };

        // Создаем JComboBox
        countryBox = new JComboBox<>(countries);

        // Надпись для информации
        infoLabel = new JLabel("Australia: capital - Canberra");

        // Добавляем элементы в окно
        add(countryBox);
        add(infoLabel);

        // Обработчик выбора страны
        countryBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String country =
                        (String) countryBox.getSelectedItem();

                if ("Australia".equals(country)) {
                    infoLabel.setText(
                            "Australia: capital - Canberra"
                    );
                }

                else if ("China".equals(country)) {
                    infoLabel.setText(
                            "China: capital - Beijing"
                    );
                }

                else if ("England".equals(country)) {
                    infoLabel.setText(
                            "England: capital - London"
                    );
                }

                else if ("Russia".equals(country)) {
                    infoLabel.setText(
                            "Russia: capital - Moscow"
                    );
                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CountryMenu();
    }
}
