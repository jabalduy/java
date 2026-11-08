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
    private JLabel frameLabel = new JLabel("Кадр: 1 из 4", JLabel.CENTER);

    public Animation(String imagePath) throws IOException {

        image = ImageIO.read(new File(imagePath));
        if (image == null) {
            throw new IOException("Файл не является изображением");
        }
        if (image.getWidth() < frameCount || image.getWidth() % frameCount != 0) {
            throw new IOException("Ширина изображения должна делиться на 4");
        }

        frameWidth = image.getWidth() / frameCount;
        frameHeight = image.getHeight();

        // Таймер: меняем кадр каждые 200 миллисекунд
        Timer timer = new Timer(200, e -> {

            currentFrame++;

            // После последнего кадра возвращаемся к первому
            if (currentFrame >= frameCount) {
                currentFrame = 0;
            }

            frameLabel.setText("Кадр: " + (currentFrame + 1) + " из " + frameCount);
            repaint();
        });

        timer.start();
    }


    public JLabel getFrameLabel() {
        return frameLabel;
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
            int width = Math.min(frameWidth, getWidth());
            int height = Math.min(frameHeight, getHeight());
            if (width <= 0 || height <= 0) return;
            g.drawImage(frame, (getWidth() - width) / 2,
                    (getHeight() - height) / 2, width, height, null);
        }
    }


    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println(
                    "Укажите путь к изображению в аргументах командной строки."
            );
            return;
        }

        SwingUtilities.invokeLater(() -> {
            try {
                Animation animation = new Animation(args[0]);
                JFrame frame = new JFrame("Animation");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout(5, 5));
                frame.add(animation, BorderLayout.CENTER);

                // Внизу отображается информация об анимации
                JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
                bottomPanel.add(new JLabel("Интервал: 200 мс", JLabel.CENTER));
                bottomPanel.add(animation.getFrameLabel());
                frame.add(bottomPanel, BorderLayout.SOUTH);

                frame.setSize(500, 400);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(),
                        "Ошибка загрузки", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}

// java Animation.java "/Users/andreytrifonov/Documents/mirea.jpeg"