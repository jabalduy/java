package block3.Prac12;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Animation extends JPanel {

    private BufferedImage image;

    private int currentFrame = 0;

    // Количество кадров в картинке
    private final int frameCount = 4;

    private int frameWidth;
    private int frameHeight;

    public Animation(String imagePath) {

        try {
            // Загружаем изображение
            image = ImageIO.read(new File(imagePath));

            // Если кадры расположены горизонтально
            frameWidth = image.getWidth() / frameCount;
            frameHeight = image.getHeight();

        } catch (IOException e) {
            System.out.println("Ошибка загрузки изображения");
            e.printStackTrace();
        }

        // Таймер: меняем кадр каждые 200 миллисекунд
        Timer timer = new Timer(200, e -> {

            currentFrame++;

            // После последнего кадра возвращаемся к первому
            if (currentFrame >= frameCount) {
                currentFrame = 0;
            }

            repaint();
        });

        timer.start();
    }


    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        if (image != null) {

            // Выбираем нужный кадр из общей картинки
            BufferedImage frame = image.getSubimage(
                    currentFrame * frameWidth,
                    0,
                    frameWidth,
                    frameHeight
            );

            // Рисуем кадр
            g.drawImage(frame, 50, 50, null);
        }
    }


    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println(
                    "Укажите путь к изображению в аргументах командной строки."
            );
            return;
        }

        JFrame frame = new JFrame("Animation");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Animation animation =
                new Animation(args[0]);

        frame.add(animation);

        frame.setSize(500, 400);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}

// java Animation.java "/Users/andreytrifonov/Documents/mirea.jpeg"