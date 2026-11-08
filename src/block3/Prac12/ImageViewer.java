package block3.Prac12;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageViewer {

    public static void main(String[] args) {

        // Проверяем, передан ли путь к картинке
        if (args.length == 0) {
            System.out.println("Укажите путь к изображению в аргументах командной строки.");
            return;
        }

        // Получаем путь к изображению
        String imagePath = args[0];

        SwingUtilities.invokeLater(() -> {
            try {
                BufferedImage image = ImageIO.read(new File(imagePath));
                if (image == null) {
                    throw new IOException("Файл не является изображением");
                }

                JLabel label = new JLabel(new ImageIcon(image));
                JFrame frame = new JFrame("Image Viewer");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(label));
                frame.setSize(Math.min(image.getWidth() + 40, 900),
                        Math.min(image.getHeight() + 60, 700));
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Не удалось открыть изображение: " +
                        e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}


// java ImageViewer.java "/Users/andreytrifonov/Documents/mirea.jpeg"