package block3.Prac5;

import javax.swing.*;

public class ImageViewer {

    public static void main(String[] args) {

        // Проверяем, передан ли путь к картинке
        if (args.length == 0) {
            System.out.println("Укажите путь к изображению в аргументах командной строки.");
            return;
        }

        // Получаем путь к изображению
        String imagePath = args[0];

        // Создаем изображение
        ImageIcon image = new ImageIcon(imagePath);

        // Создаем надпись с изображением
        JLabel label = new JLabel(image);

        // Создаем окно
        JFrame frame = new JFrame("Image Viewer");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Добавляем изображение в окно
        frame.add(label);

        // Подгоняем размер окна под изображение
        frame.pack();

        // Размещаем окно по центру
        frame.setLocationRelativeTo(null);

        // Показываем окно
        frame.setVisible(true);
    }
}


// java ImageViewer.java "/Users/andreytrifonov/Documents/mirea.jpeg"