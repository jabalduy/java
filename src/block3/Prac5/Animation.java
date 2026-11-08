package block3.Prac5;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Animation extends JPanel {

    private BufferedImage image;
    private int currentFrame = 0;
    private final int frameCount = 4;
    private boolean spriteSheet;

    public Animation(String imagePath, boolean spriteSheet) throws IOException {
        image = ImageIO.read(new File(imagePath));
        if (image == null) {
            throw new IOException("Файл не является изображением");
        }

        this.spriteSheet = spriteSheet;
        if (spriteSheet && image.getWidth() < frameCount) {
            throw new IOException("Изображение слишком узкое для четырёх кадров");
        }

        Timer timer = new Timer(200, e -> {
            currentFrame = (currentFrame + 1) % frameCount;
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image == null || getWidth() <= 0 || getHeight() <= 0) {
            return;
        }

        BufferedImage picture = image;

        if (spriteSheet) {
            // Четыре кадра подряд. Ширина не обязана делиться на 4.
            int left = currentFrame * image.getWidth() / frameCount;
            int right = (currentFrame + 1) * image.getWidth() / frameCount;
            picture = image.getSubimage(left, 0, right - left, image.getHeight());
        }

        int width = Math.min(picture.getWidth(), getWidth());
        int height = Math.min(picture.getHeight(), getHeight());

        // Обычная картинка перемещается, а картинка с кадрами меняет кадр.
        int x = (getWidth() - width) / 2;
        if (!spriteSheet) {
            x += (currentFrame - 1) * 10;
            x = Math.max(0, Math.min(x, getWidth() - width));
        }

        int y = (getHeight() - height) / 2;
        g.drawImage(picture, x, y, width, height, null);
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Укажите путь к изображению в аргументах командной строки.");
            return;
        }

        // Для картинки с четырьмя кадрами укажите вторым аргументом sprite.
        boolean spriteSheet = args.length > 1 && args[1].equalsIgnoreCase("sprite");

        SwingUtilities.invokeLater(() -> {
            try {
                Animation animation = new Animation(args[0], spriteSheet);
                JFrame frame = new JFrame("Animation");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(animation);
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
